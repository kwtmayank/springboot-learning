package com.learning.springboot.jpa.jdbc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        createTable();
    }

    public void createTable(){
        jdbcTemplate.execute("CREATE TABLE USERS(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT)");
        System.out.println("User Table created");
    }

    public int createUser(String name, int age) {
        return jdbcTemplate.update("INSERT INTO USERS(name, age) VALUES(?, ?)", name, age);
    }

    public List<User> getUserNyName(int name) {
        return jdbcTemplate.query("SELECT * FROM users WHERE name = ?", (rs, rowNum) -> {
            User user = new User();
            user.setAge(rs.getInt("age"));
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        }, name);
    }


    public int deleteUser(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public int updateUser(String name, int age) {
        return jdbcTemplate.update("UPDATE users SET name = ?, age = ? WHERE id = ?", name, age);
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> {
            User user = new User();
            user.setAge(rs.getInt("age"));
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        });
    }
}
