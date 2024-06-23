package com.heima.minio;

import com.heima.file.service.FileStorageService;
import minio.MinIOApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {
   @Autowired
    private FileStorageService fileStorageService;

   @Test
    public void testUpdateUmgFile(){
       try{
           FileInputStream fileInputStream=new FileInputStream("F:\\ak47.jpg");
           String filePath=fileStorageService.uploadHtmlFile("","ak47.jpg",fileInputStream);
           System.out.println(filePath);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
   }


    }

