package org.sid.applicationjpa;

import org.sid.applicationjpa.Service.UserService;
import org.sid.applicationjpa.entities.Role;
import org.sid.applicationjpa.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ApplicationJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationJpaApplication.class, args);
    }
@Bean
 CommandLineRunner stat(UserService userService){
        return args -> {
           User u=new User();
           u.setUserName("user1");
           u.setPassword("123456");
            userService.addNewUser(u);

            User u2=new User();
            u2.setUserName("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r-> {


                Role role1 = new Role();
                role1.setRoleName("STUDENT");
                userService.addNewRole(role1);
            });
            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","ADMIN");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

        };
 }

}

