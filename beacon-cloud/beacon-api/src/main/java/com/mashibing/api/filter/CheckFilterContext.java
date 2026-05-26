package com.mashibing.api.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
策略模式的上下文对象
实现了责任链模式
*/

@Component  //把这个类交给 Spring 容器管理，Spring 会自动创建这个对象
@RefreshScope   //开启 Nacos 配置动态刷新，修改 Nacos 配置，不用重启项目，校验规则自动生效
public class CheckFilterContext {

    // Spring的IOC会将对象全部都放到Map集合中，Spring 会自动将所有标记为 @Service 的 CheckFilter 实现类放入此 Map，键名就是 @Service 注解中指定的 value 值（如 "apikey", "ip" 等）
    // 基于4.x中Spring提供的泛型注解，基于Map只拿到需要的类型对象即可
    @Autowired
    //Map 的 key = Bean 的名字
    //Map 的 value = Bean 对象
    private Map<String,CheckFilter> checkFiltersMap;

    //@Value用于，从配置文件（本地 application.yml/ Nacos 配置中心）读取配置值，赋值给变量
    @Value("${filters:apikey,ip,sign,template,mobile,fee}")
    private String filters;

    /*
    * 当前check方法用于管理校验链的顺序*/
    public void check(Object obj){
        //1.将获取到的filters基于“,”做切分
        String[] filterArray = filters.split(",");
        //2. 遍历数组即可
        for (String filter : filterArray) {
            CheckFilter checkFilter = checkFiltersMap.get(filter);
            checkFilter.check(obj);
        }
    }
}
