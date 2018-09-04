package com.code.security.core;

import com.code.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * com.code.security.core
 *
 * @Auther: shenc
 * @Date: 2018/9/3 21:22
 * @Description:
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.httpBasic()
        http.formLogin()
           // .loginPage("/signIn.html")
            .loginPage("/authentication/require")
             .loginProcessingUrl("/authentication/form")
            .and()
            .authorizeRequests()
            //.antMatchers("/signIn.html").permitAll()
            .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()).permitAll()
            .anyRequest()  //任何请求
            .authenticated()//都需要授权
            .and()
            .csrf().disable();
    }
}
