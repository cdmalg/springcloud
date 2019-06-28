package com.cloud.ribbon.hystrix.service.impl;

import com.cloud.ribbon.hystrix.service.IRibbonHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonHystrixService")
public class RibbonHystrixServiceImpl implements IRibbonHystrixService {

  @Resource
  RestTemplate restTemplate;

  @Override
  @HystrixCommand(fallbackMethod = "error")
  public String hello(String name) {
    return restTemplate.getForObject("http://springcloud-eureka-client/eureka_cli/hello?name="+name,String.class);
  }

  public String error(String name){
    return "hi,"+name+",sorry,error!";
  }
}
