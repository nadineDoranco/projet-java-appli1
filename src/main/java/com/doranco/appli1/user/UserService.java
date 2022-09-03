package com.doranco.appli1.user;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() throws Exception {
        return null;
    }

    @Override
    public User saveUser(User user) throws Exception {

        return userRepository.save(user);
    }

    @Override
    public List<User> afficherUser(PageRequest of) {
        return userRepository.findAll();
    }



    @Override
    public User detailsUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String supprimerUser(String username) {
        userRepository.deleteById(username);
        return "L'utilisateur a bien été supprimé ";
    }


}
