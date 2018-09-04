package com.code.security.core.properties;

/**
 * com.code.security.core.properties
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:14
 * @Description:
 */
public class BrowserProperties {
    private String loginPage = "/signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
