package com.joinx;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
   @Autowired
   private WebApplicationContext wac;
   private MockMvc mvc;
   @Before
   public void setup(){
      mvc=MockMvcBuilders.webAppContextSetup(wac).build();
   }
   @Test
   public void test1(){
      try {
         String content = mvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "zhangsan")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andReturn().getResponse().getContentAsString();
         ;
         System.out.println(content);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   @Test
   public void test2() throws Exception {
      String s = mvc.perform(MockMvcRequestBuilders.get("/user/1")
             .contentType(MediaType.APPLICATION_JSON_UTF8)
      ).andExpect(MockMvcResultMatchers.status().isOk())
             .andReturn().getResponse().getContentAsString();
      System.out.println(s);
   }
   @Test
   public void whenCreateSuccess() throws Exception {
      Date date=new Date();
      long time = date.getTime();
      String context="{\"name\":\"赵六\",\"sex\":\"女\",\"dateTime\":"+time+"}";
      String 赵六 = mvc.perform(MockMvcRequestBuilders.post("/user")
             .contentType(MediaType.APPLICATION_JSON_UTF8)
             .content(context))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("赵六"))
             .andReturn().getResponse().getContentAsString();
      System.out.println(赵六);
//             .andExpect(MockMvcResultMatchers.jsonPath("$.dateTime").value("2019-09-13T06:56:21.703+0000"))
      ;
   }
   @Test
   public void whenUploadSuccess() throws Exception {
      mvc.perform(MockMvcRequestBuilders
      .fileUpload("/file")
      .file(new MockMultipartFile
             ("file","text.txt",
                    "multipart/for-data",
                    "hello upload".getBytes("UTF-8"))))
             .andExpect(MockMvcResultMatchers.status().isOk());
   }
}
