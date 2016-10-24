package com.example.viknox.facebookintegration;

import java.net.URL;


// POJO object to store user data
public class User {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public URL getPic() {
        return Pic;
    }

    public void setPic(URL pic) {
        Pic = pic;
    }

    String Name;
    String Age;
    String Email;
    String gender;
    String tags;
    URL Pic;

}
