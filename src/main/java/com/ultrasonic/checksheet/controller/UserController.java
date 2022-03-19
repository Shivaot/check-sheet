package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.User;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Shiva Created on 09/03/22
 */
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("list")
    public String users(Model model) {
        model.addAttribute("title", "CheckSheet - Users List");
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String userEdit(@Param(value = "id") Long id, HttpSession session, Model model) {
        Optional<User> optionalProduct = userRepository.findById(id);
        try {
            User user = optionalProduct.get();
            model.addAttribute("u", user);
            return "user/edit";
        } catch (NoSuchElementException ex) {
            log.error("User not found ", ex);
            session.setAttribute("message", new Message("User Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }

    @PostMapping("update")
    public String updateUserDetails(@Valid @ModelAttribute("u") User user, BindingResult result,
                                    HttpSession session, Model model, Principal principal) {

        try {
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving user {}", result);
                model.addAttribute("u", user);
                return "user/edit";
            }
            User savedUser = userRepository.findById(user.getId()).get();
            savedUser.setRole(user.getRole());
            savedUser.setEmail(user.getEmail());
            if (user.getPassword() != null) {
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                savedUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin updated user with email {}", user.getEmail());
            userRepository.save(savedUser);
            session.setAttribute("message", new Message("Successfully Updated User", "alert-success"));
            return "redirect:/user/list";
        } catch (Exception ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Error while updating user", ex);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "redirect:/user/list";
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteUser(@Param(value = "id") Long id, HttpSession session, Principal principal) {
        Optional<User> optionalUser = userRepository.findById(id);
        try {
            User user = optionalUser.get();
            userRepository.delete(user);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin deleted user with ID {}", id);
            session.setAttribute("message", new Message("User deleted successfully with ID" + id, "alert-success"));
            return "redirect:/user/list";
        } catch (NoSuchElementException ex) {
            log.error("User not found ", ex);
            session.setAttribute("message", new Message("User Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("title", "CheckSheet - Create User");
        model.addAttribute("u", new User());
        return "user/create";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("u") User user, BindingResult result,
                              HttpSession session, Model model, Principal principal) {

        try {
            User savedUser = userRepository.findByEmail(user.getEmail().trim());
            if(savedUser != null){
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving user {}", result);
                model.addAttribute("u", user);
                result.rejectValue("email", "error.email", "Email already present!");
                return "user/create";
            }
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving user {}", result);
                model.addAttribute("u", user);
                return "user/create";
            }
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin added user with email {}", user.getEmail());
            session.setAttribute("message", new Message("Successfully Added User", "alert-success"));
            return "redirect:/user/list";
        } catch (Exception ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Error while saving user", ex);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "user/create";
        }
    }
}
