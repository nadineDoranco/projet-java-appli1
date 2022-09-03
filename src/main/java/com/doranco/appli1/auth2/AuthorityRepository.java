package com.doranco.appli1.auth2;

import com.doranco.appli1.auth2.Authority;
import com.doranco.appli1.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    List<Authority> findAuthoritiesByUsersContains(User user);
}
