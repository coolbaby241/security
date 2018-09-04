package com.code.security.browser;


import com.code.security.browser.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * com.code.security.browser
 *
 * @Auther: shenc
 * @Date: 2018/9/3 21:22
 * @Description:
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.httpBasic()
        http.formLogin()
           // .loginPage("/signIn.html")
            .loginPage("/authentication/require")
            .loginProcessingUrl("/authentication/form")
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailureHandler)
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
