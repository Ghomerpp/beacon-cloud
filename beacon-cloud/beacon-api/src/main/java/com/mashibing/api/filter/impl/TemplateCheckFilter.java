package com.mashibing.api.filter.impl;

import com.mashibing.api.filter.CheckFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
* 校验客户apikey是否合法*/
@Slf4j
@Service(value = "template")
public class TemplateCheckFilter implements CheckFilter {

    @Override
    public void check(Object obj){
        log.info("【接口模块-校验模板】   校验ing............");
    }
}
