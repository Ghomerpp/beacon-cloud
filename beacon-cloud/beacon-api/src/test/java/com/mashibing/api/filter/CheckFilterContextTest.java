package com.mashibing.api.filter;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class CheckFilterContextTest {


    @org.junit.Test
    public void check() {
        String xxx = "【】";
        String sign = xxx.substring(1,xxx.indexOf("】"));
        System.out.println(sign);
    }
}