package com.atharva.libraryjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.atharva.libraryjdbc.model.Admin;
import com.atharva.libraryjdbc.model.Student;
import com.atharva.libraryjdbc.model.User;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUsers(User user){
        String sql="INSERT INTO users (name,type) values (?,?)";

        try{
            jdbcTemplate.update(sql, user.getName(),user.getType());
            System.out.println("User added successfully");
        }
        catch(DataAccessException e){
            System.out.println("Error is DB communication User NOT ADDED");
            System.out.println(e.getMessage());
        }
    }

    public User getUserById(int id){
        String sql="SELECT * FROM users WHERE user_id=?";

        RowMapper <User> mapper=new RowMapper<User>() {
            
            @Override
            public User mapRow(ResultSet rs, int rowNum)throws SQLException{
                
                if(rs.getString("type").equals("Student")){
                    User fetchedUser=new Student();
                    fetchedUser.setName(rs.getString("name"));
                    fetchedUser.setUserId(rs.getInt("user_id"));
                    fetchedUser.setType(rs.getString("type"));

                    return fetchedUser;
                }
                else{
                    User fetchedUser=new Admin();
                    fetchedUser.setName(rs.getString("name"));
                    fetchedUser.setUserId(rs.getInt("user_id"));
                    fetchedUser.setType(rs.getString("type"));
                    return fetchedUser;
                }
            }
        };

        return jdbcTemplate.queryForObject(sql, mapper, id);
       }

    
       public List<User> getAllUsers(){
        String sql="SELeCT * FROM users";

        RowMapper <User>mapper=new RowMapper<User>() {
            
            @Override
            public User mapRow(ResultSet rs,int rowNum) throws SQLException{
                if(rs.getString("type").equals("Student")){
                    User fetchedUser=new Student();
                    fetchedUser.setName(rs.getString("name"));
                    fetchedUser.setUserId(rs.getInt("user_id"));
                    fetchedUser.setType(rs.getString("type"));

                    return fetchedUser;
                }
                else{
                    User fetchedUser=new Admin();
                    fetchedUser.setName(rs.getString("name"));
                    fetchedUser.setUserId(rs.getInt("user_id"));
                    fetchedUser.setType(rs.getString("type"));
                    return fetchedUser;
                }
            }
        };

        return jdbcTemplate.query(sql, mapper);
       }


    
}
