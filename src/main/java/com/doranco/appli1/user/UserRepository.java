package com.doranco.appli1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource
@RequestMapping
public interface IUserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String username);


}
