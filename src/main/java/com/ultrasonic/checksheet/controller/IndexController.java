package com.ultrasonic.checksheet.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Shiva Created on 05/03/22
 */
@Slf4j
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
            boolean isOperator = authorities.contains(new SimpleGrantedAuthority("ROLE_OPERATOR"));
            String nameOf = authentication.getName();
            if (isAdmin) {
                log.info("ADMIN Login {}", nameOf);
                return "redirect:/check-sheet/list";
            } else if (isOperator){
                log.info("OPERATOR Login {}", nameOf);
                return "redirect:/operator/check-sheet/create";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String customLogin(Model model) {
        model.addAttribute("title", "Login Page");
        return "login";
    }
}
