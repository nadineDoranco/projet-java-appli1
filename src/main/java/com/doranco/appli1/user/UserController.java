package com.doranco.appli1.user;



import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserPage(
            Model model,
            @RequestParam(name="size", defaultValue = "5") int size,
            @RequestParam(name="page", defaultValue = "0") int page) {

        try {
            List<User> users = userService.afficherUser(PageRequest.of(page,size));
            model.addAttribute("users", users);
            //model.addAttribute("pages", new int[users.getTotalPages()]);
            model.addAttribute("current_page", page);
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }
        return "users";
    }

    @PostMapping(path= "save",produces = "application/json")
    public String saveUser(
            @ModelAttribute("user") User user
    ) {
        try {
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/users";
    }

    @RequestMapping(path="update/{username}")
    public ModelAndView updateUser(
            @PathVariable(name = "username") String username
    ) {
        try {
            ModelAndView modelAndView = new ModelAndView("u_update");

            User user = userService.detailsUser(username);
            modelAndView.addObject("user", user);

            return modelAndView;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path= "update/save",produces = "application/json")
    public String updateUser(
            @ModelAttribute("user") User user
    ) {
        try {
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/users";
    }

    @RequestMapping(path = "delete/{username}")
    public String deleteUser(
            @PathVariable(name = "username") String username
    ) {
        try {
            userService.supprimerUser(username);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/users";
    }

}

