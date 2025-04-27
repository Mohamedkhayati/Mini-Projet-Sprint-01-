package com.mohamed.supplements;

import com.mohamed.supplements.entities.Role;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.entities.User;
import com.mohamed.supplements.service.SupplementService;
import com.mohamed.supplements.service.UserService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class SupplementsApplication implements CommandLineRunner {

    @Autowired
    private SupplementService supplementService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;  // Added @Autowired here

    public static void main(String[] args) {
        SpringApplication.run(SupplementsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Password Encoded BCRYPT :******************** ");
        System.out.println(passwordEncoder.encode("123"));
        /* supplementService.saveSupplement(new Supplement("Whey Protein", "30g", 29.99, "Optimum Nutrition", new Date()));
        supplementService.saveSupplement(new Supplement("Creatine", "5g", 19.99, "MuscleTech", new Date()));
        supplementService.saveSupplement(new Supplement("BCAA", "10g", 24.99, "Scivation", new Date()));*/
    }

    @PostConstruct
    void init_users() {
        // Check if userService is not null before using it
        if (userService != null) {
            //ajouter les rôles
            userService.addRole(new Role(null,"ADMIN"));
            userService.addRole(new Role(null,"AGENT"));
            userService.addRole(new Role(null,"USER"));
            
            //ajouter les users with encoded passwords
            userService.saveUser(new User(null,"admin",passwordEncoder.encode("123"),true,null));
            userService.saveUser(new User(null,"mohamed",passwordEncoder.encode("123"),true,null));
            userService.saveUser(new User(null,"user1",passwordEncoder.encode("123"),true,null));
            
            //ajouter les rôles aux users
            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("mohamed", "USER");
            userService.addRoleToUser("mohamed", "AGENT");
            userService.addRoleToUser("user1", "USER");
        }
    }
}