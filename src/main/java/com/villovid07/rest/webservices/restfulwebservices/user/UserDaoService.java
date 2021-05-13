/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.villovid07.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;


/**
 *
 * @author villovid07
 */
@Component
public class UserDaoService {
    
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 6;
    
    static {
        users.add(new User( 1, "Bingo", new Date()));
        users.add(new User( 2, "Anna", new Date()));
        users.add(new User( 3, "David", new Date()));
        users.add(new User( 4, "Coco", new Date()));
        users.add(new User( 5, "Bruce", new Date()));
        
    }
    
    
    public List<User> findAll(){
        return this.users;
    }
    
    public User save(User user){
        if(user.getId() == null){
            user.setId(usersCount++);
        }
        users.add(user);
        return user;
    }
    
    public User findOne(int id){
        for( User user:users){
            if(user.getId()== id){
                return user;
            }
        }
        return null;
    }
    
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
    
    


    
}
