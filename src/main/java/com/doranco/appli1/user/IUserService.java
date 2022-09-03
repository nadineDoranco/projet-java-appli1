package com.doranco.appli1.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
   List<User> getAllUsers() throws Exception;
   User saveUser(User user) throws Exception;

   List<User> afficherUser(PageRequest of);



   User detailsUser(String id);

   String supprimerUser(String id);
}
