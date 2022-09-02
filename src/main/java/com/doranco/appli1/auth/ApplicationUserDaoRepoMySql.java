package com.doranco.appli1.projetjava.appli1.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import org.test.tp01.user.Authority;
import org.test.tp01.user.AuthorityRepository;
import org.test.tp01.user.User;
import org.test.tp01.user.UserRepository;

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

        /*Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        for(Authority authority : authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }*/

        return new ApplicationUserDetail(
                user.getPassword(),
                user.getUsername(),
                grantedAuthorities,
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled()
        );
    }
}
