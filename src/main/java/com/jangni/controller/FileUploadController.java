package com.jangni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(value = "/file.html")
    public String file(String name, MultipartFile file){

        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
          System.out.println(fileName);
        }
        return "upload.btl";
    }
    @RequestMapping(value = "/upload.html")
    public String upload(){

        return "upload.btl";
    }
    @RequestMapping(value = "/files.html")
    public String files(MultipartFile[] files){
        for (MultipartFile file : files) {
            if(!file.isEmpty()){
                String fileName = file.getOriginalFilename();
                System.out.println(fileName);
            }
        }

        return "upload.btl";
    }
}
