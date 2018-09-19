package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private @Autowired
    UserRepository userRepository;
    private @Autowired
    ProfileRepository profileRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("ali");
        user = userRepository.save(user);

        Profile profile = new Profile();
        profile.setProfileName("parent");
        profile.assignUser(user.getId());
        profileRepository.save(profile);

//        System.out.println(profileRepository.findAll());
        System.out.println(userRepository.findAll());

    }
}
