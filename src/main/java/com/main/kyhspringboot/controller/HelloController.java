package com.main.kyhspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "/hello";

    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "/hello-template";

    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;

    }

    @GetMapping("/hello-api")
    @ResponseBody
    //객체로 리턴하는 경우는 jsonConverter가 작동
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;


        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
