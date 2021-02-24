package com.SPRINGupgradWEBapp.myfirstspringapp.service;

import com.SPRINGupgradWEBapp.myfirstspringapp.model.User;

/*package com.upgrad.BlogPostApplication.service;


import com.upgrad.BlogPostApplication.model.User;*/
import org.springframework.stereotype.Service;


@Service
public class UserService {
    public boolean login(User user)
    {
        if(user.getUsername().equals("Baljinder_1088")&&user.getPassword().equals("baljinder@1088"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
