package com.atharva.libraryjdbc.Servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atharva.libraryjdbc.model.IssuedBooks;
import com.atharva.libraryjdbc.repository.IssueRepository;

@Service
public class IssuedBookServiceImp implements IssuedBookService {
    

    private IssueRepository issueRepository;

    public IssueRepository getIssueRepository() {
        return issueRepository;
    }

    @Autowired
    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
    
    @Override
     public void issueBook(IssuedBooks issueBook){
        issueRepository.issueBook(issueBook);
     }

     @Override
     public void returnBook(int id){
        issueRepository.returnBook(id);
     }

     @Override
     public List<IssuedBooks> getAllIssuedBooks(){
        return issueRepository.getAllIssuedBooks();
     }

     @Override
     public List<IssuedBooks> getAllIssuedBooksByUser(int id){
        return issueRepository.getAllIssuedBooksByUser(id);
     }


}
