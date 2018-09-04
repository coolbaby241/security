package com.code.security.browser.dto;

import java.io.Serializable;

/**
 * com.code.dto
 *
 * @Auther: shenc
 * @Date: 2018/8/26 22:39
 * @Description:
 */
public class UserCondition implements Serializable {

    private String username;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
