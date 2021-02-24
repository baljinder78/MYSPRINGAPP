package com.SPRINGupgradWEBapp.myfirstspringapp.service;


import com.SPRINGupgradWEBapp.myfirstspringapp.model.Post;

/*
package com.upgrad.BlogPostApplication.service;


import com.upgrad.BlogPostApplication.model.Post;*/
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {


    private static ArrayList<Post> POSTS=new ArrayList<Post>();

/*
    static {

        Post post1=new Post();
        post1.setTitle("Worldwide");
        post1.setBody("Chitkara university is not opening college");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2=new Post();
        post2.setTitle("Music");
        post2.setBody("Ansh sharma is a great beat boxer");
        post2.setDate(new Date());
        POSTS.add(post2);


        Post post3=new Post();
        post3.setTitle("Tech");
        post3.setBody("AI is the upcoming future");
        post3.setDate(new Date());
        POSTS.add(post3);


    }




//----------------------------------------------------
    /*public ArrayList<Post> getallPosts()
    {
        ArrayList<Post> posts=new ArrayList<>();
        Post post1=new Post();
        post1.setTitle("user's Post");
        post1.setBody("body of user");
        post1.setDate(new Date());

        posts.add(post1);
        return posts;
    }*/
//----------------------------------------------------

    private final String url="jdbc:postgresql://localhost:5432/technicalblog";
    private final String username="postgres";
    private final String password="password";


    public Connection connect() throws SQLException
    {
        return DriverManager.getConnection(url,username,password);
    }





    public ArrayList<Post> getallPosts()
    {
        //Business Logic for connecting the database
        try
        {
            //step1: connect
            Connection connection=connect();

            //Step2:get/create statement
            Statement statement=connection.createStatement();

            //step3 : execute the select querry
            ResultSet resultset=statement.executeQuery("select * from posts");

        while (resultset.next())
        {
            Post post1=new Post();
            post1.setTitle(resultset.getString("title"));
            post1.setBody(resultset.getString("body"));
            post1.setDate(resultset.getDate("date"));

            //singleton is arraylist
            POSTS.add(post1);

        }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return POSTS;
    }
    /*
    public void createPost(Post newpost)
    {
        POSTS.add(newpost);
    }

    */


    public void createPost(Post newPost)
    {
        String query="insert into posts(title,body,date) values(?,?,?)";

        try
        {
            Connection connection=connect();

            PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,newPost.getTitle());
            preparedStatement.setString(2,newPost.getBody());
            preparedStatement.setDate(3,new Date(newPost.getDate().getTime()));


            int updatedRows=preparedStatement.executeUpdate();
        if(updatedRows>0)
        {
            System.out.println("Update Successfull");
        }


        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
