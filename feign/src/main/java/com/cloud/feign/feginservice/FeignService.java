package com.cloud.feign.feginservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "springcloud-eureka-client")
public interface FeignService {

  @GetMapping("/eureka_cli/hello")
  String hello(@RequestParam String name);
}
