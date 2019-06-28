package com.cloud.fegin.hystrix.service.impl;

import com.cloud.fegin.hystrix.feign.FeignService;
import com.cloud.fegin.hystrix.service.IFeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feignHystrixService")
public class FeignHystrixServiceImpl implements IFeignHystrixService {

  @Autowired
  FeignService feignService;

  @Override
  public String hello(String name) {
    return feignService.hello(name);
  }
}
