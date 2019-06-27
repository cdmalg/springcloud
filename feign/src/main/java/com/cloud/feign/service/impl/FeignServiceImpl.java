package com.cloud.feign.service.impl;

import com.cloud.feign.feginservice.FeignService;
import com.cloud.feign.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feignService")
public class FeignServiceImpl implements IFeignService {

  @Autowired
  FeignService feignService;

  @Override
  public String hello(String name) {
    return feignService.hello(name);
  }
}
