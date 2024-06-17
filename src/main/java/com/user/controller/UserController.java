package com.user.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.model.User;
import com.user.model.UserBean;
import com.user.dto.UserDTO;
import com.user.repository.UserReposity;

@Controller
public class UserController {
    @Autowired
      ModelMapper mapper;

    @Autowired
     UserReposity userRepo;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserBean ());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserBean userBean, Model model) {
        UserDTO userDTO = new UserDTO();
        mapper.map(userBean, userDTO);
        User user = mapper.map(userDTO, User.class);
		userRepo.addUser(user);
		
		
        return "success";
    }
}
