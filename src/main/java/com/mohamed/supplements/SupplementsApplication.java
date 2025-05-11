package com.mohamed.supplements;

import com.mohamed.supplements.entities.Role;
import com.mohamed.supplements.entities.Supplement;
import com.mohamed.supplements.entities.User;
import com.mohamed.supplements.service.SupplementService;
/*import com.mohamed.supplements.service.UserService;*/

import jakarta.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/

@SpringBootApplication
public class SupplementsApplication implements CommandLineRunner {

    private final SupplementService supplementService;
    /*private final PasswordEncoder passwordEncoder;*/
    /*private final UserService userService;*/

    @Autowired
    public SupplementsApplication(SupplementService supplementService
                                  /*PasswordEncoder passwordEncoder,*/) {
        this.supplementService = supplementService;
      /*  this.passwordEncoder = passwordEncoder;*/
      /*  this.userService = userService;*/
    }
  
    public static void main(String[] args) {
        SpringApplication.run(SupplementsApplication.class, args);
    }

    @Override
    public void run(String... args) {

      /*  System.out.println("Password Encoded BCRYPT :******************** ");
        System.out.println(passwordEncoder.encode("123"));*/

        // Example to add supplements
        /*
        supplementService.saveSupplement(new Supplement("Whey Protein", "30g", 29.99, "Optimum Nutrition", new Date()));
        supplementService.saveSupplement(new Supplement("Creatine", "5g", 19.99, "MuscleTech", new Date()));
        supplementService.saveSupplement(new Supplement("BCAA", "10g", 24.99, "Scivation", new Date()));
        */
    }

  /*  @PostConstruct
    public void initUsers() {
        // Add roles if not exist
        if (!userService.roleExists("ADMIN")) userService.addRole(new Role(null, "ADMIN"));
        if (!userService.roleExists("AGENT")) userService.addRole(new Role(null, "AGENT"));
        if (!userService.roleExists("USER")) userService.addRole(new Role(null, "USER"));

        // Add users if not exist (raw passwords will be encoded inside service)
        if (!userService.userExists("admin"))
            userService.saveUser(new User(null, "admin", "123", true, null));
        if (!userService.userExists("mohamed"))
            userService.saveUser(new User(null, "mohamed", "123", true, null));
        if (!userService.userExists("user1"))
            userService.saveUser(new User(null, "user1", "123", true, null));

        // Assign roles to users
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("mohamed", "USER");
        userService.addRoleToUser("mohamed", "AGENT");
        userService.addRoleToUser("user1", "USER");
    }*/

}
