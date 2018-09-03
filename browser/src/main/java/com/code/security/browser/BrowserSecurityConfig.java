package com.code.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * com.code.security.browser
 *
 * @Auther: shenc
 * @Date: 2018/9/3 21:22
 * @Description:
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.formLogin()
        http.httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest()  //任何请求
            .authenticated(); //都需要授权
    }
}
