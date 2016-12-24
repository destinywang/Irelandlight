package com.irelandlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by destiny on 2016/12/21.
 */
@Controller
@RequestMapping("/destiny")
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("IndexController.hello");
        return "hello";
    }

}
