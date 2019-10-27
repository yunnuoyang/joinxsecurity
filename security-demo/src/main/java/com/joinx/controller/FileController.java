package com.joinx.controller;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/file")
public class FileController {
   @PostMapping
   public void upload(MultipartFile file){
      System.out.println(file.getOriginalFilename()+"===");
      System.out.println(file.getName()+"===");
   }
}
