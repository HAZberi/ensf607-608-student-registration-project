package com.student_reg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String hello() {
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// Statement stmt = Application.createStatement();
		// String sql = "SELECT StudentName FROM STUDENT WHERE StudentID = '" + 1000000001 +"'";
		// ResultSet rs = stmt.executeQuery(sql);
		return "Hello World";
	}

}
