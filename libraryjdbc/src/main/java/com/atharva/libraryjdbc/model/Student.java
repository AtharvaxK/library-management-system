package com.atharva.libraryjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student extends User{

    @Override
    public String getRole(){
        return "Student";
    }




}
