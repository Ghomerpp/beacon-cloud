package com.mashibing.api.filter.impl;

import com.mashibing.api.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
* 校验客户apikey是否合法*/

@Slf4j  //生成日志记录器
@Service(value = "apikey")  //它会创建 ApiKeyCheckFilter 的实例，将这个实例存储在容器中，命名为 "apikey"
public class ApiKeyCheckFilter implements CheckFilter {

    @Override
    public void check(Object obj){
        log.info("【接口模块-校验apikey】   校验ing............");
    }
}
