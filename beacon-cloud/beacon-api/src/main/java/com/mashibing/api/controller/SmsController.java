package com.mashibing.api.controller;


import com.alibaba.nacos.common.utils.StringUtils;
import com.mashibing.api.enums.SmsCodeEnum;
import com.mashibing.api.form.SingleSendForm;
import com.mashibing.api.util.R;
import com.mashibing.api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.net.HttpHeaders.X_FORWARDED_FOR;


/*
请求路径：** https://sms.beaconcloud.com/v1/sms/single_send
请求方式：** POST
| 请求头       | 请求信息                         |
| ----------- | ------------------------------ |
| Accept      | application/json;charset=utf-8 |
| ContentType | application/json;charset=utf-8 |

| 参数名 | 类型    | 是否必传 | 说明                                     | 示例                             |
| ------ | ------- | -------- | ---------------------------------------- | -------------------------------- |
| apikey | string  | 是       | 由服务方提供，可以在后台首页中查看       | 887559db54d911edba520242ac120002 |
| mobile | string  | 是       | 接收的手机号，仅支持单号码发送           | 18888888888                      |
| text   | string  | 是       | 需要发送的短信内容，需要与签名和模板匹配 | 【烽火云】 您的验证码是 1234     |
| uid    | string  | 否       | 您业务系统内的ID，回调时会携带此参数     | 10086                            |
| state  | integer | 是       | 0-验证码短信 1-通知类短信 2-营销类短信   | 0                                |
* */
@Slf4j
@RestController
@RequestMapping("/sms")
@RefreshScope
public class SmsController {

    /**
     * 客户端IP地址的请求头信息，多个用','隔开。
     */
    @Value("${headers}")
    private String headers;

    /**
     * 基于请求头获取信息时，可能获取到的未知信息
     */
    private final String UNKNOW = "unknow";


    @PostMapping(value = "/single_send",produces = "application/json;charset=utf-8")
    //@RequestBody 将请求体自动反序列化为 SingleSendForm 对象
    //@Validated 触发表单验证
    public ResultVO singleSend(@RequestBody @Validated SingleSendForm singleSendForm, BindingResult bindingResult,HttpServletRequest req){
        //1. 校验参数
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【接口模块-单挑短信Controller】参数不合法 msg = {}",msg);
            return R.error(SmsCodeEnum.PARAMETER_ERROR.getCode(),msg);
        }
        //========================获取真实IP地址==========================
        String ip = this.getRealIP(req);
        System.out.println(ip);

        //========================构建StandarSubmit,各种封装校验==========================
        System.out.println(req.getRemoteAddr());

        //========================发送到MQ,交给策略模块处理==========================

        return R.ok();
    }



    /*
    * 获取真实IP地址
    * */
    private String getRealIP(HttpServletRequest req) {
        //0. 声明真实IP地址
        String ip;

        //2. 遍历请求头，并且通过req获取ip地址
        for (String header : headers.split(",")) {
            // 健壮性校验
            if (!StringUtils.isEmpty(header)) {
                // 基于req获取ip地址
                ip = req.getHeader(header);
                // 如果获取到的ip不为null，不为空串，并且不为unknow，就可以返回
                if (!StringUtils.isEmpty(ip) && !UNKNOW.equalsIgnoreCase(ip)) {
                    // 判断请求头是否是x-forwarded-for
                    if (X_FORWARDED_FOR.equalsIgnoreCase(header) && ip.indexOf(",") > 0) {
                        ip = ip.substring(0,ip.indexOf(","));
                    }
                    // 返回IP地址
                    return ip;
                }
            }
        }

        //3. 如果请求头都没有获取到IP地址，直接基于传统的方式获取一个IP
        return req.getRemoteAddr();


        /*//1. 基于x-forwarded-for请求头获取IP地址
        String ips = req.getHeader("x-forwarded-for");
        //  直接基于第一个,的位置，截取需要的IP地址
        if (StringUtils.isEmpty(ips) || "unknow".equalsIgnoreCase(ips)) {
            if(ips.contains(",")){
                return ips.substring(0, ips.indexOf(","));
            }else{
                return ips;
            }
        }

        // 2. 基于请求头获取IP地址，基于request请求头获取信息时，除了null和空串外，还有可能拿到unknow，
        ip = req.getHeader("x-real-ip");
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)){
            // x-real-ip没拿到，考虑一下其他的代理服务器
            //3.  Apache的服务器，请求头中携带真实IP的名称是 proxy-client-ip
            ip = req.getHeader("proxy-client-ip");
        }

        //4. 如果real没有拿到，判断apache是否拿到了。
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)){
            // 5. 如果Apache服务器没拿到，考虑一手WebLogic, wl-proxy-client-ip
            ip = req.getHeader("wl-proxy-client-ip");
        }

        //6. 判断WebLogic有木有拿到IP
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)){
            //7. 基于其他的代理服务器的方式获取请求头的IP地址
            ip = req.getHeader("http_client_ip");
        }
        //8. 如果上诉方式都获取不到，
        if (StringUtils.isEmpty(ip) || "unknow".equalsIgnoreCase(ip)){
            // 9. 基于传统方式获取IP
            ip = req.getRemoteAddr();
        }
        //10. 返回
        return ip;*/
    }
}
