package com.code.security.core;

import com.code.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * com.code.security.core.properties
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:17
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
