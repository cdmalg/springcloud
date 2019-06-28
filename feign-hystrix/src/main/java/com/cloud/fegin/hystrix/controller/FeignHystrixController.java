package com.cloud.fegin.hystrix.controller;

import com.cloud.fegin.hystrix.service.IFeignHystrixService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign_hystrix")
public class FeignHystrixController {

  @Resource
  IFeignHystrixService feignHystrixService;

  @GetMapping("/hello")
  public String hello(@RequestParam String name){
    return feignHystrixService.hello(name);
  }
}
