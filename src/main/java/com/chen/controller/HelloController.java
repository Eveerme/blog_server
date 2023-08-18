package com.chen.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyingtao
 * @Date 2023/7/27 11:48
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("@aeu.hasAuthority('sys:stu:list')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/noHello")
    @PreAuthorize("@aeu.hasAuthority('sys:stu:get')")
    public String noHello(){
        return "hello";
    }

}
