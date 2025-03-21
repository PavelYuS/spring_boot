package com.pavelyudnikov.spring.springboot.spring_boot.controller;

import com.pavelyudnikov.spring.springboot.spring_boot.model.User;
import com.pavelyudnikov.spring.springboot.spring_boot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/id")
    public String show(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/id/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.remove(id);
        return "redirect:/users";
    }

    @GetMapping("/id/edit")
    public String edit(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping("/id")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(user);
        return "redirect:/users";
    }
}


