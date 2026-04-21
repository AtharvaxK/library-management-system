package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atharva.libraryjdbc.model.Book;
import com.atharva.libraryjdbc.repository.BookRepository;

@Service
public class BookServiceImp implements BookService {


    private BookRepository repository;

     public BookRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public void addBook(Book book){
        repository.addBook(book);
    }
    @Override
    public List<Book> getAllBooks(){
       return repository.getAllBooks();
    }
    @Override
    public void updateQuantity(int quantity,int id){
        repository.updateQuantity(quantity, id);
    }
    @Override
    public void deleteBook(int id){
        repository.deleteBook(id);
    }
    public List<Book> seachByTitle(String title){
        return repository.seachByTitle(title);
    }
    public List<Book> seachByAuthor(String author){
       return  repository.seachByAuthor(author);
    }

    @Override
    public Book getBookById(int id) {

       return repository.getBookById(id);
    }
    public void updateBook(Book book){
         repository.updateBook(book);
    }
}
