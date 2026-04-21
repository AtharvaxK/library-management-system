package com.atharva.libraryjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Admin extends User {
    @Override
    public String getRole(){
        return "Admin";
    }
}
