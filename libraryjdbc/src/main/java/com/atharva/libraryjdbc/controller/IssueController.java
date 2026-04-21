package com.atharva.libraryjdbc.controller;

import com.atharva.libraryjdbc.Servicelayer.IssuedBookService;
import com.atharva.libraryjdbc.model.IssuedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IssueController {

    @Autowired
    private IssuedBookService issuedBookService;

    @RequestMapping("/issuedBooks")
    public String issuebook(Model model){
        model.addAttribute("issuedBooks",issuedBookService.getAllIssuedBooks());
        return "issuedBooks";
    }

    @RequestMapping("/issueBook")
    public String issueBook(){

        return "issueBook";
    }

    @RequestMapping(value = "/saveIssue" ,method= RequestMethod.POST)
    public String saveIssue(@ModelAttribute IssuedBooks issuedBooks){
        issuedBookService.issueBook(issuedBooks);
        return "redirect:/issuedBooks";
    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam int id){
        issuedBookService.returnBook(id);
        return "redirect:/issuedBooks";
    }
}
