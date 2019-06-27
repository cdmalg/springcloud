package com.cloud.ribbon.controller;

import com.cloud.ribbon.service.IRibbonService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

  @Resource
  IRibbonService ribbonService;

  @GetMapping("/hello")
  public String hello(@RequestParam String name){
    return ribbonService.hello(name);
  }

}
