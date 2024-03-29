package com.Syrtsov.base_sec.controllers;

import com.Syrtsov.base_sec.domain.entity.Role;
import com.Syrtsov.base_sec.domain.entity.User;
import com.Syrtsov.base_sec.domain.repo.UserRepo;
import com.Syrtsov.base_sec.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(User user, Model model)
    {
        if (!userService.addUser( user))
        {
            model.addAttribute("message", "Пользователь уже существует!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        if(isActivated){
            model.addAttribute("message", "Пользователь активирован");
        } else {
            model.addAttribute("message", "Код активации не найден");
        }
        return "login";
    }

}
