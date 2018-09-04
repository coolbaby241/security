package com.code.security.browser;

import com.code.security.browser.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * com.code.security.browser.properties
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:17
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
