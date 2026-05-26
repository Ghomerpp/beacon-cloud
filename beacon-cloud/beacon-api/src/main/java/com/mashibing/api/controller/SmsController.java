package com.mashibing.api.controller;


import com.mashibing.api.enums.SmsCodeEnum;
import com.mashibing.api.form.SingleSendForm;
import com.mashibing.api.util.R;
import com.mashibing.api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
public class SmsController {

    @PostMapping(value = "/single_send",produces = "application/json;charset=utf-8")
    //@RequestBody 将请求体自动反序列化为 SingleSendForm 对象
    //@Validated 触发表单验证
    public ResultVO singleSend(@RequestBody @Validated SingleSendForm singleSendForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【接口模块-单挑短信Controller】参数不合法 msg = {}",msg);
            return R.error(SmsCodeEnum.PARAMETER_ERROR.getCode(),msg);
        }
        //========================构建StandarSubmit,各种封装校验==========================


        //========================发送到MQ,交给策略模块处理==========================

        return R.ok();
    }
}
