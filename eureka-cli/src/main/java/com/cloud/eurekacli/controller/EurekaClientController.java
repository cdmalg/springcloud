package com.cloud.eurekacli.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eureka_cli")
public class EurekaClientController {

  @Value(("${server.port}"))
  String port;

  @GetMapping("/hello")
  public String helloWorld(@RequestParam String name){

    return "hi, "+name+". my port is "+port+", hello world!";
  }
}
