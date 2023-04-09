package com.example.gourmet;

import com.example.gourmet.Entity.appRole;
import com.example.gourmet.Entity.appUser;
import com.example.gourmet.Service.Implementation.AdminServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class GourmetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GourmetApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


    @Bean
	CommandLineRunner start(AdminServiceImpl accountService){
        return args -> {
            accountService.addNewRole(new appRole(null,"Client"));
            accountService.addNewRole(new appRole(null,"Admin"));
            accountService.addNewRole(new appRole(null,"Manger"));

			 accountService.saveUser(new appUser(null,"hamza laqraa","shadow","1234","test@test.com",new ArrayList<>(),new HashSet<>()));
			 accountService.saveUser(new appUser(null,"hamid bassou","soul","1234","hamid@test.com",new ArrayList<>(),new HashSet<>()));
			accountService.saveUser(new appUser(null,"salim ahmad","curry","1234","salim@test.com",new ArrayList<>(),new HashSet<>()));



			accountService.addRoleToUser("shadow","Client");
            accountService.addRoleToUser("Soul","Admin");
			accountService.addRoleToUser("curry","Manger");

        };
    }

}
