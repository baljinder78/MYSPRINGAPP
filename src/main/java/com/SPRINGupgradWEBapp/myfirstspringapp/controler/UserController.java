package com.SPRINGupgradWEBapp.myfirstspringapp.controler;

import com.SPRINGupgradWEBapp.myfirstspringapp.model.Post;
import com.SPRINGupgradWEBapp.myfirstspringapp.model.User;
import com.SPRINGupgradWEBapp.myfirstspringapp.service.UserService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService=new UserService();

    @RequestMapping(method = RequestMethod.GET,value = "/users/login")
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "users/login";
    }
    @RequestMapping(method = RequestMethod.POST,value = "/users/login")
    public String loginusers(User user)
    {
        if(userService.login(user))
        {
            return "redirect:/posts";
        }
        else
        {
            return "/login";
        }
    }


    //registration

    @RequestMapping(method = RequestMethod.GET,value = "/users/registration")
    public String registration()
    {
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users/registration")
    public String userRegistration(User user)
    {
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout()
    {

       return "redirect:/";
    }
}
