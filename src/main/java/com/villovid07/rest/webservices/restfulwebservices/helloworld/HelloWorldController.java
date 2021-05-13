/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.villovid07.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author villovid07
 */

@RestController
public class HelloWorldController {
    
    @GetMapping(path="/hello-world")
    public String helloWolrd(){
        return "Hello Wold";
    }
    
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hola mundo");
    }
    
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hola mundo %s", name));
    }
    
    
    
}
