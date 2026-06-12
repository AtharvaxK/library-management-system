package com.atharva.libraryjdbc;


import com.atharva.libraryjdbc.Servicelayer.BookService;
import com.atharva.libraryjdbc.Servicelayer.IssuedBookService;
import com.atharva.libraryjdbc.Servicelayer.UserService;
import com.atharva.libraryjdbc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller{

    @Autowired
    private BookService bookService;
    @Autowired
    private IssuedBookService issuedBookService;
    @Autowired
    private UserService userService;

    @GetMapping("books")
    @CrossOrigin("http://localhost:3000/")
    public List<Book> getAllJobs(){
        return bookService.getAllBooks();
    }

    @GetMapping("book/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("issues")
    @CrossOrigin("http://localhost:3000/")
    public List<IssuedBooks> getIssuedBooks(){
        return issuedBookService.getAllIssuedBooks();
    }

    @GetMapping("users")
    @CrossOrigin("http://localhost:3000")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("books")
    @CrossOrigin("http://localhost:3000")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PostMapping("users")
    @CrossOrigin("http://localhost:3000")
    public void addUser(@RequestBody UserRequest userReq){
        if(userReq.getType().equals("student")){
            Student student=new Student();
            student.setName(userReq.getName());
            student.setType(userReq.getType());
            userService.addUsers(student);
        }
        else {
            Admin admin=new Admin();
            admin.setName(userReq.getName());
            admin.setType(userReq.getType());
            userService.addUsers(admin);
        }
    }

    @PostMapping("issues")
    @CrossOrigin("http://localhost:3000")
    public void addIssue(@RequestBody IssuedBooks issuedBooks){
        issuedBookService.issueBook(issuedBooks);
    }

    @PutMapping("issues/{id}/return")
    @CrossOrigin("http://localhost:3000")
    public void returnBook(@PathVariable int id){
        issuedBookService.returnBook(id);
    }

    @DeleteMapping("users/{id}")
    @CrossOrigin("http://localhost:3000")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @DeleteMapping("books/{id}")
    @CrossOrigin("http://localhost:3000")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }


}
