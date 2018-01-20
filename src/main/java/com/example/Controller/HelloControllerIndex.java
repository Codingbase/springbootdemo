package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller 可以使用thymeleaf模板加载html
@Controller
public class HelloControllerIndex {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String Hi() {
        return "index";
    }

    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public String req() {
        return "reqtest";
    }

    @RequestMapping(value = "/local", method = RequestMethod.GET)
    public String local() {
        return "local";
    }
}
