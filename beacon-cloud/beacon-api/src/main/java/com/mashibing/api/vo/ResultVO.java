package com.mashibing.api.vo;


import lombok.Data;

/*
**响应数据：**

| 名称  | 类型    | 说明                                                            |
| ----- | ------- | ------------------------------------------------------------ |
| code  | integer | 0代表接收成功，其他code代表出错                                   |
| msg   | string  | 例如“接收成功”，代表短信正在发送，或者是响应具体的错误信息              |
| count | integer | 短信的计费条数（70个字一条，超出70个字，按照67个字一条发送）            |
| fee   | long    | 扣费的金额，单位：厘 ，RMB                                   |
| uid   | string  | 客户请求携带的uid信息                                        |
| sid   | long    | 平台内的短信id，64位整型                                     |
*/

/*
@Data 注解相当于同时使用了以下几个 Lombok 注解：

@ToString：自动生成 toString() 方法
@EqualsAndHashCode：自动生成 equals() 和 hashCode() 方法
@Getter：为所有字段自动生成 getter 方法
@Setter：为所有非 final 字段自动生成 setter 方法
@RequiredArgsConstructor：自动生成包含所有 final 字段和 @NonNull 字段的构造函数
*/
@Data
public class ResultVO {

    private Integer code;

    private String msg;

    private Integer count;

    private Long fee;

    private String uid;

    private String sid;
}
