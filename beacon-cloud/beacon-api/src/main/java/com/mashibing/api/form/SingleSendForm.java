package com.mashibing.api.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*@Data 是 Lombok 提供的，会自动帮你生成所有字段的 getter、setter、toString、equals、hashCode。e`。*/
@Data
public class SingleSendForm {
    /** @NotBlank 验证注解确保该字段不为空白（不仅不为 null，也不能是纯空白字符）
如果验证失败，会显示 "apikey不能为空" 错误信息*/

    /**客户apikey*/
    @NotBlank(message = "apikey不能为空")
    private String apikey;

    /**接收的手机号，仅支持单号码发送*/
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    /**需要发送的短信内容，需要与签名和模板匹配*/
    @NotBlank(message = "短信内容不能为空")
    private String text;

    /**您业务系统内的ID，回调时会携带此参数*/
    private String uid;

    /*@Range 验证注解确保数值在 0 到 2 之间0 代表验证码短信，1 代表通知类短信，2 代表营销类短信如果超出范围，会显示 "短信类型只能是0、1、2" 错误信息*/

    /*状态    0-验证码短信 1-通知类短信 2-营销类短信*/
    @Range(min = 0, max = 2, message = "短信类型只能是0、1、2")
    @NotNull(message = "不能为null")
    private Integer state;
}
