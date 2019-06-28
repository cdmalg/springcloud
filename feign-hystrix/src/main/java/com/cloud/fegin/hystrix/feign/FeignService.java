package com.cloud.fegin.hystrix.feign;

import com.cloud.fegin.hystrix.feign.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "springcloud-eureka-client",fallback = FeignServiceImpl.class)
public interface FeignService {

  @GetMapping(value = "/eureka_cli/hello")
  public String hello(@RequestParam String name);

}
