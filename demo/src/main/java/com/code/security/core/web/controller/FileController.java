package com.code.security.core.web.controller;

import com.code.security.core.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * com.code.web.controller
 *
 * @Auther: shenc
 * @Date: 2018/9/2 16:31
 * @Description:
 */
@RestController
public class FileController{
    private String folder = "D:\\myCode\\spring_security\\security\\demo\\src\\main\\java\\com\\code\\web\\controller";

    @PostMapping("/file")
    public FileInfo upload(MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder,new Date().getTime()+ ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/file/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try (InputStream inputStream = new FileInputStream(new File(folder,id + ".txt"));
             OutputStream outputStream = response.getOutputStream();
                ){
             response.setContentType("application/x-download");
             response.addHeader("Content-Disposition","attachment;filename=test.txt ");
             //下载
             IOUtils.copy(inputStream,outputStream);
             outputStream.flush();
        }
    }


}
