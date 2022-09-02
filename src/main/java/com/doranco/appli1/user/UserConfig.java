package com.doranco.appli1.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static AuthConfig createAuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        return new AuthConfig(userRepository, authorityRepository, passwordEncoder);
    }

    @Bean
    CommandLineRunner init_product() {
        return args -> {
            userRepository.save(new User("Nadine","nadine@gmail.com","0123456123"));

            userRepository.save(new User("Daphnée","daphnee@gmail.com","0130005673"));

        };
    }

    /*@Bean
    CommandLineRunner initUserAdmin() {
        return args -> {
            User user_admin = userRepository.save(new User("admin",passwordEncoder.encode("123")));



            Authority authority_write = authorityRepository.save(new Authority("location : write"));
            Authority authority_read = authorityRepository.save(new Authority("location : read"));
            Authority authority_delete = authorityRepository.save(new Authority("location : delete"));
            Authority role_admin = authorityRepository.save(new Authority("ROLE_ADMIN"));

            role_admin.getUsers().add(user_admin);
            authorityRepository.save(role_admin);

            authority_write.getUsers().add(user_admin);
            authorityRepository.save(authority_write);

            authority_read.getUsers().add(user_admin);
            authorityRepository.save(authority_read);


            authority_delete.getUsers().add(user_admin);
            authorityRepository.save(authority_delete);
        };


    }*/
}
