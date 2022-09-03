package com.doranco.appli1.user;

import com.doranco.appli1.auth2.AuthorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    private final UserRepository userRepository;
    private final  AuthorityRepository authorityRepository ;
    private final PasswordEncoder passwordEncoder ;

    public UserConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserConfig createAuthConfig(UserRepository userRepository) {

        return new UserConfig(userRepository, authorityRepository, passwordEncoder);
    }

    @Bean
    CommandLineRunner init_product() {
        return args -> {
            userRepository.save(new User("Montella","Nadine","nadine@gmail.com","0123456123"));

            userRepository.save(new User("Duchêne","Daphnée","daphnee@gmail.com","0130005673"));

        };
    }


}
