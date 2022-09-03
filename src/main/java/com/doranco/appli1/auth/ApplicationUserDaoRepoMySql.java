package com.doranco.appli1.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import com.doranco.appli1.auth2.Authority;
import com.doranco.appli1.auth2.AuthorityRepository;
import com.doranco.appli1.user.User;
import com.doranco.appli1.user.UserRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ApplicationUserDaoRepoMySql implements ApplicationUserDao{

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public ApplicationUserDaoRepoMySql(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public ApplicationUserDetail getUserByUsername(String username) {

        User user = userRepository.findUserByUsername(username);
        List<Authority> authorities = authorityRepository.findAuthoritiesByUsersContains(user);
        Set<SimpleGrantedAuthority> grantedAuthorities = authorities
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toSet());

        return new ApplicationUserDetail(
                user.getPassword(),
                user.getUsername(),
                grantedAuthorities
        );
    }
}
