package com.doranco.appli1.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    List<Authority> findAuthoritiesByUsersContains(User user);
}
