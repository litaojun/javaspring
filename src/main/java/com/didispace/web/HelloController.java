package com.didispace.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didispace.test.util.TestCase;



@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    @RequestMapping(value = "/ssss/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
        return "Hello " + name;
    }
   // @RequestBody User  user
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public User sayWorld(@RequestBody User  user) 
    {
        return user;
    }
    
    @RequestMapping(value = "/paramtest", method = RequestMethod.GET)
    public String paramfun(@RequestParam("name") String name,@RequestParam("age") int age) 
    {
    	System.out.println(String.format("name=%s,age=%s", new String[]{name,String.valueOf(age)}));
        return name + age;
    }
    @TestCase(ifname = "paramtest", cstype = 1,rule = {99,199}, cls = Class.class)
    public String paramfunsstt(@RequestParam("name") String name,@RequestParam("age") int age) 
    {
    	System.out.println(String.format("name=%s,age=%s", new String[]{name,String.valueOf(age)}));
        return name + age;
    }
    
}