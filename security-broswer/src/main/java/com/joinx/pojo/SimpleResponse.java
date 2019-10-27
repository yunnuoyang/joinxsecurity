package com.joinx.pojo;

public class SimpleResponse {
   private Object content;
   
   public SimpleResponse(Object content) {
      this.content = content;
   }
   
   public SimpleResponse() {
   }
   
   public Object getContent() {
      return content;
   }
   
   public void setContent(Object content) {
      this.content = content;
   }
}
