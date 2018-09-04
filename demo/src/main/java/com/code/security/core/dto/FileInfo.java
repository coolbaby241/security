package com.code.security.core.dto;

/**
 * com.code.dto
 *
 * @Auther: shenc
 * @Date: 2018/9/2 16:34
 * @Description:
 */
public class FileInfo {
    public FileInfo(String path){
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
