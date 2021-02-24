package com.SPRINGupgradWEBapp.myfirstspringapp.model;

import javax.persistence.*;


@Entity
@Table(name="testTable")
public class test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "testID")
    private int id;

    @Column(name = "testName")
    private String name;

    @Column(name = "testemail")
    private String email;


    @Column(name = "testpass")
    private String password;


    public test(int id, String name, String email, String password) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
