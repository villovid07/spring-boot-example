/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.villovid07.rest.webservices.restfulwebservices.helloworld;

/**
 *
 * @author villovid07
 */
class HelloWorldBean {
    
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" + "message=" + message + '}';
    }
    
    
    
    
    
}
