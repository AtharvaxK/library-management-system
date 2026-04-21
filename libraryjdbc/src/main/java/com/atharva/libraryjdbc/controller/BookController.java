package com.atharva.libraryjdbc.controller;

import com.atharva.libraryjdbc.Servicelayer.BookService;
import com.atharva.libraryjdbc.Servicelayer.BookServiceImp;
import com.atharva.libraryjdbc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String getAllbooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());

        return "books";
    }
    @RequestMapping("/addBook")
    public String addBook(){
        return "addBook";
    }

    @RequestMapping(value="/saveBook", method=RequestMethod.POST)
    public String addBookForm(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/editBook")
    public String editBook(@RequestParam int id , Model model){

        model.addAttribute("book", bookService.getBookById(id));
        return "editBook";
    }

    @RequestMapping(value = "/updateBook" ,method = RequestMethod.POST)
    public String editBookform(@ModelAttribute Book book ){
        bookService.updateBook(book);
        return "redirect:/books";
    }
}
