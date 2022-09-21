package com.hs.shop.controller.route;

import com.hs.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Foo
 * @version 1.0
 */

@Controller
public class Route {
    @Autowired
    UserService service;

    @GetMapping("/")
    public String goIndex() {
        return "index-mz";
    }

    @GetMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String goRegister(){
        return "sign-in";
    }


}
