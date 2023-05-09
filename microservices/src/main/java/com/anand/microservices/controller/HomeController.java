package com.anand.microservices.controller;

import com.anand.microservices.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String home(){

        return "Hello World!";
    }

    //@RequestMapping(value="/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user1 = new User("123","Anand","anjiammu@gmail.com");

        return user1;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id, @PathVariable("id2") String name){
        return "The path variable is:"+id+" and :"+name;
    }

}
