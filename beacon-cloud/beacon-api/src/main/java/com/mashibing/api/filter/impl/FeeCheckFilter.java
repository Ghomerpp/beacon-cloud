package com.mashibing.api.filter.impl;

import com.mashibing.api.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
* 校验客户apikey是否合法*/
@Slf4j
@Service(value = "fee")
public class FeeCheckFilter implements CheckFilter {

    @Override
    public void check(Object obj){
        log.info("【接口模块-校验客户余额】   校验ing............");
    }
}
