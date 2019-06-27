package com.cloud.ribbon.service.impl;

import com.cloud.ribbon.service.IRibbonService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ribbonService")
public class RibbonServiceImpl implements IRibbonService {

  @Resource
  RestTemplate restTemplate;

  @Override
  public String hello(String name) {
    return restTemplate.getForObject("http://springcloud-eureka-client/eureka_cli/hello?name="+name,String.class);
  }
}
