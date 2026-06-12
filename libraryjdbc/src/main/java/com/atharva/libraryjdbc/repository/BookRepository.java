package com.atharva.libraryjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.atharva.libraryjdbc.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

@Repository
public class BookRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book){
        String sql="Insert InTo books(title,author,quantity) VALUES (?,?,?)";


        try {
            jdbcTemplate.update(sql,book.getTitle(),book.getAuthor(),book.getQuantity());
            System.out.println("Books added succssfully");
        }
            catch (DataAccessException e){
                System.out.println("Books addition failed");
                System.out.println(e.getMessage());
            }
    }

    public List<Book> getAllBooks(){
        String sql="SELECT * fROM books";

        RowMapper <Book>mapper =new RowMapper<Book>() {
            
            @Override
            public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
                Book book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                
                return book;
            }
        };
        return jdbcTemplate.query(sql,mapper);

    }

    public void updateQuantity(int quantity,int id){
        String sql="UPDATE books SET quantity = ? WHERE book_id=?";

        try{
            int rows=jdbcTemplate.update(sql,quantity,id );
            if(rows>0){
            System.out.println("Updated successfullly");
            }
            else{
                System.out.println("No book found");
            }
        }
        catch(DataAccessException e){
            System.out.println("Failed to update");
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(int id){
        String sql="DELETE FROM books WHERE book_id=?";

        try {
            int rows=jdbcTemplate.update(sql,id);
            if(rows>0){
            System.out.println("Deleted successfullly");
            }
            else{
                System.out.println("No book found");
            }
        } catch (DataAccessException e) {
            System.out.println("Error in DB communication!");
            System.out.println(e.getMessage());
        
        }
    }

    public List<Book> seachByTitle(String title){
        String sql="SELECT * FROM books WHERE title LIKE ?";

        RowMapper<Book>mapper=new RowMapper<Book>(){

            @Override
            public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
                Book book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                
                return book;
            }
        };
        return jdbcTemplate.query(sql,mapper,"%"+title+"%");
        

    }

    public List<Book> seachByAuthor(String author){
        String sql="SELECT * FROM books WHERE author LIKE ?";

        RowMapper<Book>mapper=new RowMapper<Book>(){

            @Override
            public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
                Book book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));
                
                return book;
            }
        };
        return jdbcTemplate.query(sql,mapper,"%"+author+"%");
        

    }

    public Book getBookById(int id){
        String sql="Select * FROM books where book_id=?";

        RowMapper<Book>mapper=new RowMapper<Book>(){

            @Override
            public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
                Book book=new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setQuantity(rs.getInt("quantity"));

                return book;
            }
        };
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    public void updateBook(Book book){
        String sql="UPDATE books SET title=?, author=?, quantity=? WHERE book_id=?";
        try {


            jdbcTemplate.update(sql, book.getTitle(),  book.getAuthor(),book.getQuantity(),book.getBookId());
        }
        catch (DataAccessException e){
            System.out.println(e.getMessage());
        }
        }



 }
