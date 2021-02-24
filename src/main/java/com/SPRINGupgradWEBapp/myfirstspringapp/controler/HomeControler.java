package com.SPRINGupgradWEBapp.myfirstspringapp.controler;

import com.SPRINGupgradWEBapp.myfirstspringapp.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeControler {

    @RequestMapping("/")
    public String getAllPost(Model model){

        ArrayList<Post> posts=new ArrayList<>();

        Post post1=new Post();
        post1.setTitle("Smartphones");
        post1.setBody("I love androids");
        post1.setDate(new Date());

        Post post2=new Post();
        post2.setTitle("Chitkara");
        post2.setBody("Chitkara is playing with students");
        post2.setDate(new Date());


        Post post3=new Post();
        post3.setTitle("Thechnology");
        post3.setBody("Tesla uses AI");
        post3.setDate(new Date());


        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts",posts);
        return "index";
    }
}
