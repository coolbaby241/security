package com.code.security.browser.web.service.impl;

import com.code.security.browser.web.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * com.code.web.service.impl
 *
 * @Auther: shenc
 * @Date: 2018/8/29 22:48
 * @Description:
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
