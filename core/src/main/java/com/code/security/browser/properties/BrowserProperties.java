package com.code.security.browser.properties;

/**
 * com.code.security.browser.properties
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:14
 * @Description:
 */
public class BrowserProperties {
    private String loginPage = "/signIn.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
