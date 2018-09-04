package com.code.security.core.exception;

/**
 * com.code.exception
 *
 * @Auther: shenc
 * @Date: 2018/8/30 22:19
 * @Description:
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public UserNotExistException(String id){
        super("user not exist");
        this.id = id ;
    }

}
