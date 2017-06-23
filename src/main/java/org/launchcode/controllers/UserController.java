package org.launchcode.controllers;

import org.launchcode.models.data.UserDao;
import org.launchcode.models.forms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by henry on 5/11/17.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayloginForm(Model model) {
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(Model model, @RequestParam String loginUsername, @RequestParam String loginPassword) {
        Iterable<User> users = userDao.findAll();

        for (User user : users) {
            if (user.getUsername().equals(loginUsername)) {
                if (user.getPassword().equals(loginPassword)) {
                    model.addAttribute("user", user);
                    return "user/welcome";
                }
                else {
                    model.addAttribute("title", "Login");
                    model.addAttribute("loginUsername", loginUsername);
                    return "user/login";
                }
            }
            else {
                model.addAttribute("title", "Login");
                model.addAttribute("loginUsername", loginUsername);
                return "user/login";
            }
        }
        model.addAttribute("users", users);
        return "user/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, String verifyPassword, Model model) {

        boolean passwordsMatch = true;
        if (user.getPassword() == null || verifyPassword == null || !user.getPassword().equals(verifyPassword)) {
            passwordsMatch = false;
            user.setPassword("");
            model.addAttribute("verifyPasswordError", "Passwords must match");
        }
        if (!errors.hasErrors() && passwordsMatch) {
            userDao.save(user);
            return "user/welcome";
        }
        model.addAttribute("title", "Add User");
        return "user/add";
    }
}

