package com.doranco.appli1.user;


import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;







@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService =userService;
    }

    @GetMapping
    public List<User> getAllUsers(
            @RequestParam(name="size", defaultValue = "5") int size,
            @RequestParam(name="page", defaultValue = "0") int page){

        List<User> users;
        try {
            users = userService.afficherUser(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @PostMapping("/poster")
    public User saveUser(
            @RequestBody User user
    ) {

        try {
            user = userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}