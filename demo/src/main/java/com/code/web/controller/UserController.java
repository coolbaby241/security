package com.code.web.controller;

import com.code.dto.User;
import com.code.dto.UserCondition;
import com.code.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * com.code.web.controller
 *
 * @Auther: shenc
 * @Date: 2018/8/26 22:37
 * @Description:
 */
@RestController
@RequestMapping("/user" )
public class UserController {

    @GetMapping("/query")
    public List<User> query(@RequestParam(name="nickname",required = false, defaultValue = "tom") String username){
        System.out.println(username);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
    @RequestMapping(value = "/userObject" , method = RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> queryObject(UserCondition user, @PageableDefault(page = 2, size = 17,sort = "username,asc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(required = true) String id){
//        throw new UserNotExistException(id);
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping("/add")
    public User create(@Valid @RequestBody User user ,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @PutMapping("/update")
    public User update(@Valid @RequestBody User user ,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                        FieldError fieldError = (FieldError) error;
                        String message = fieldError.getField() + error.getDefaultMessage();
                        System.out.println(message);
                    }
                    );
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@ApiParam(value = "用户ID") @PathVariable String id){
        System.out.println(id);
    }



}
