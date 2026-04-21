package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import com.atharva.libraryjdbc.model.Book;


public interface  BookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    void updateQuantity(int quantity,int id);
    void deleteBook(int id);
    List<Book> seachByTitle(String title);
    List<Book> seachByAuthor(String author);
    Book getBookById(int id);
    void updateBook(Book book);

}
