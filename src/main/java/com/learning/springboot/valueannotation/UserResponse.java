package com.learning.springboot.valueannotation;

import com.learning.springboot.hateoas.HateoasLinks;

public class UserResponse extends HateoasLinks {

    private String name;
    private String email;

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
}
