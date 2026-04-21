package com.atharva.libraryjdbc.controller;

import com.atharva.libraryjdbc.Servicelayer.UserService;
import com.atharva.libraryjdbc.model.Admin;
import com.atharva.libraryjdbc.model.Student;
import com.atharva.libraryjdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public String users(Model model ){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/addUser")
    public String addUser(){
        return "addUsers";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String addUserForm(@RequestParam String name, @RequestParam String type) {
        if (type.equals("Student")) {
            Student student = new Student();
            student.setName(name);
            student.setType(type);
            userService.addUsers(student);
        } else {
            Admin admin = new Admin();
            admin.setName(name);
            admin.setType(type);
            userService.addUsers(admin);
        }
        return "redirect:/users";
    }

}
