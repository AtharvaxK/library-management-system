package com.atharva.libraryjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//import org.jspecify.annotations.Nullable;
import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atharva.libraryjdbc.model.IssuedBooks;

@Repository
public class IssueRepository {
    
    
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void issueBook(IssuedBooks issueBook){
        String sql="INSERT INTO issued_books(user_id,book_id,issue_date) VALUES (?,?,?)";

        try{
            jdbcTemplate.update(sql,issueBook.getUserId(),issueBook.getBookId(),LocalDateTime.now());
            System.out.println("Book Issued Successfully");
        }
        catch(DataAccessException e){
            System.out.println("Book not Issued");
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int id){
        String sql="UPDATE issued_books SET return_date =? WHERE issue_id=?";

        try{
            jdbcTemplate.update(sql,LocalDateTime.now(),id);
            System.out.println("Book returned Successfully");
        }
        catch(DataAccessException e){
            System.out.println("Book not returned");
            System.out.println(e.getMessage());
        }

    }

    public List<IssuedBooks> getAllIssuedBooks(){
        String sql="SELECT * FROM issued_books";

        RowMapper <IssuedBooks>mapper;
        mapper = new RowMapper<IssuedBooks>() {
            
            @Override
            public IssuedBooks mapRow(ResultSet rs,int rowNum) throws SQLException{
               IssuedBooks issuedBooks=new IssuedBooks();
               issuedBooks.setUserId(rs.getInt("user_id"));
               issuedBooks.setBookId(rs.getInt("book_id"));
               issuedBooks.setIssueId(rs.getInt("issue_id"));
               issuedBooks.setIssueDate(rs.getTimestamp("issue_date").toLocalDateTime());
                Timestamp returnDate = rs.getTimestamp("return_date");
                issuedBooks.setReturnDate(returnDate != null ? returnDate.toLocalDateTime() : null);

               return issuedBooks;
            }
        };

        return jdbcTemplate.query(sql, mapper);
    }

    public List<IssuedBooks> getAllIssuedBooksByUser(int id){
        String sql="SELECT * FROM issued_books WHERE user_id=?";

        RowMapper <IssuedBooks>mapper;
        mapper = new RowMapper<IssuedBooks>() {
            
            @Override
            public IssuedBooks mapRow(ResultSet rs,int rowNum) throws SQLException{
               IssuedBooks issuedBooks=new IssuedBooks();
               issuedBooks.setUserId(rs.getInt("user_id"));
               issuedBooks.setBookId(rs.getInt("book_id"));
               issuedBooks.setIssueId(rs.getInt("issue_id"));
               issuedBooks.setIssueDate(rs.getTimestamp("issue_date").toLocalDateTime());
               issuedBooks.setReturnDate(rs.getTimestamp("return_date").toLocalDateTime());

               return issuedBooks;
            }
        };

        return jdbcTemplate.query(sql, mapper,id);
    }

    
}
