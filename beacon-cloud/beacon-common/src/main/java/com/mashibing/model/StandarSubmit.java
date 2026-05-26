package com.mashibing.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



/*
 * 在接口模块-策略模块-短信网关模块需要做校验和封装的POJO类对象*/

/*
* 用户请求
    ↓
beacon-api（接口模块）
  SmsController 接收请求 → SingleSendForm（只有用户传来的原始字段）
    ↓
  把 SingleSendForm 的数据 + 系统补充的数据 → 封装成 StandarSubmit
    ↓
  CheckFilterContext 拿着 StandarSubmit 做各种校验
    ↓
策略模块（各个 CheckFilter）
  每个 filter 从 StandarSubmit 里读取自己需要的字段来校验
    ↓
短信网关模块
  拿 StandarSubmit 里的 channelId、srcNumber 等字段真正发短信
*/


@Data
@NoArgsConstructor  //生成一个无参构造方法：
@AllArgsConstructor //生成一个包含所有字段的构造方法：
public class StandarSubmit {

    /*针对当前短信的唯一标识*/
    private Long sequenceId;

    /*客户端Id，基于apikey查询缓存模块得到客户Id*/
    private Long clientId;

    /*客户端的ip白名单*/
    private String ip;

    /**客户业务内的uid，客户请求传递的参数*/
    private String uid;

    /**目标手机号，客户请求传递的参数*/
    private String mobile;

    /**短信内容的签名，客户请求传递的参数，只需要在【】中获取出来*/
    private String sign;

    /**短信内容*/
    private String text;

    /**短信的发送时间，当前系统时间*/
    private LocalDateTime sendTime;

    /**当前短信的费用,计算费用70个字一条，超出部分67个字一条*/
    private Long fee;

    /* 目标手机号的运营商*/
    private Integer operatorId;

    /**目标手机号的归属地区号  0451  0455 （策略模块）*/
    private Integer areaCode;

    /**目标手机号的归属地  哈尔滨，  绥化 （策略模块）* /
    private String area;

    /**通道下发的源号码  106934985673485645 （策略模块）*/
    private String srcNumber;

    /**通道的id信息（策略模块）*/
    private Long channelId;

    /**短信的发送状态， 0-等待ing，1-成功，2-失败，默认为0*/
    private int reportState;

    // 后续再做封装~~~~
}
