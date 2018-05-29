package com.gaozhaoxi.entity;

import java.util.List;

/**
 * @author Leon
 */
public class User {
    private Long id;
    private String username;
    private List<String> interest;

    public User(){

    }
    public User(Long id ,String username,List<String> interest){
        this.id=id;
        this.username=username;
        this.interest=interest;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        String str="{id:"+id+",username:"+username+",interest:"+interest+"}";
        return str;
    }
}
