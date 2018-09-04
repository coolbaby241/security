package com.code.security.core.dto;

import com.code.security.core.web.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * com.code.dto
 *
 * @Auther: shenc
 * @Date: 2018/8/26 22:39
 * @Description:
 */
public class User implements Serializable {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private Integer id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是一个测试")
    @ApiModelProperty(value = "说明")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    @JsonView(UserDetailView.class)
    private Integer age;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
