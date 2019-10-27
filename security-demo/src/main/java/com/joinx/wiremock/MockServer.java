package com.joinx.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

public class MockServer {
   public static void main(String[] args) {
      WireMock.configureFor(9999);
      //清空以前的配置项
      WireMock.removeAllMappings();
      
      WireMock.stubFor(
             WireMock.get(WireMock.urlPathEqualTo("/user/1"))
             .willReturn(WireMock.aResponse()
             .withBody("{\"name\":\"s\",\"sex\":\"男\"}")
             .withStatus(200))
             );
   }
}
