package com.cloud.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ProducerFallback implements FallbackProvider {

  @Override
  public String getRoute() {
    return "springcloud-ribbon";
  }

  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    return new ClientHttpResponse() {
      @Override
      public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.NOT_FOUND;
      }

      @Override
      public int getRawStatusCode() throws IOException {
        return HttpStatus.NOT_FOUND.value();
      }

      @Override
      public String getStatusText() throws IOException {
        return HttpStatus.NOT_FOUND.getReasonPhrase();
      }

      @Override
      public void close() {

      }

      @Override
      public InputStream getBody() throws IOException {
        return new ByteArrayInputStream((getRoute() + " fallback").getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }
    };
  }


}
