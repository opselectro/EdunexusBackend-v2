package com.tka.StudentLearningApp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tka.StudentLearningApp.Repository.UserRepo;
import com.tka.StudentLearningApp.entity.Users;

@Configuration
public class AdminSecureConfig {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public CommandLineRunner createAdmin(UserRepo userRepo)
	{
		return args-> {
			String defaultAdminEmail="admin757@elearning.com";
			
			
			 if (!userRepo.existsByEmail(defaultAdminEmail)) {
	                Users admin = new Users();
	                admin.setUsername("Admin");
	                admin.setEmail(defaultAdminEmail);
	                admin.setPassword(passwordEncoder.encode("D$9rT!2qL@vF7#Xe")); 
	                admin.setRole("ADMIN");

	                userRepo.save(admin);
	                System.out.println("Default admin user created.");
	            } else {
	                System.out.println("Default admin already exists.");
	            }
	        };
	    }
	}

