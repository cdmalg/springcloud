package com.cloud.fegin.hystrix.feign.impl;

import com.cloud.fegin.hystrix.feign.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

  @Override
  public String hello(String name) {
    return "hi,"+name+",sorry,error!";
  }
}
