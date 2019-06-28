package com.cloud.ribbon.hystrix.controller;

import com.cloud.ribbon.hystrix.service.IRibbonHystrixService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbon_hystrix")
public class RibbonHystrixController {

  @Resource
  IRibbonHystrixService ribbonHystrixService;

  @GetMapping("/hello")
  private String hello(@RequestParam String name){
    return ribbonHystrixService.hello(name);
  }
}
