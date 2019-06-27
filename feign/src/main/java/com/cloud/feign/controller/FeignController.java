package com.cloud.feign.controller;

import com.cloud.feign.service.IFeignService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

  @Resource
  IFeignService feignService;

  @GetMapping("/hello")
  public String hello(@RequestParam String name){
    return feignService.hello(name);
  }
}
