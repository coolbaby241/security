package com.code.security.core;

/**
 * com.code.security.core
 *
 * @Auther: shenc
 * @Date: 2018/9/4 22:05
 * @Description:
 */
public class SimpleResponse {

    public SimpleResponse(Object content){
        this.content = content;
    };

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
