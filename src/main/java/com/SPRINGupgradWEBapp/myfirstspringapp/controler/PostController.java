package com.SPRINGupgradWEBapp.myfirstspringapp.controler;

import com.SPRINGupgradWEBapp.myfirstspringapp.model.Post;
import com.SPRINGupgradWEBapp.myfirstspringapp.service.PostService;

/*
package com.upgrad.BlogPostApplication.controler;
import com.upgrad.BlogPostApplication.service.PostServie;


import com.upgrad.BlogPostApplication.model.Post;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {


    @RequestMapping("/posts")
    public String getUserpost(Model model)
    {
        PostService postService=new PostService();
        ArrayList<Post> posts=postService.getallPosts();
        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/posts/newpost")
    public String newpost()
    {
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/posts/create")
    public String createNewPost(Post newpost)
    {

        PostService postService=new PostService();
        newpost.setDate(new Date());
        postService.createPost(newpost);
        return "redirect:/posts";
    }
}
