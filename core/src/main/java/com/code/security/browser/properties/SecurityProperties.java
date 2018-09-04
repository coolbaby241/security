package com.code.security.browser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * com.code.security.browser.properties
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:13
 * @Description:
 */

@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
