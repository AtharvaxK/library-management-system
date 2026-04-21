package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import com.atharva.libraryjdbc.model.IssuedBooks;

public interface  IssuedBookService {
    public void issueBook(IssuedBooks issueBook);
     public void returnBook(int id);
     public List<IssuedBooks> getAllIssuedBooks();
     public List<IssuedBooks> getAllIssuedBooksByUser(int id);
     
}
