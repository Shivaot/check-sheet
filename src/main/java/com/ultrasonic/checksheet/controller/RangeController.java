package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.JointRange;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.CheckSheetRepository;
import com.ultrasonic.checksheet.repository.RangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.Join;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

/**
 * Shiva Created on 09/03/22
 */
@Slf4j
@Controller
@RequestMapping("range")
public class RangeController {

    private final RangeRepository rangeRepository;
    private final CheckSheetRepository checkSheetRepository;

    public RangeController(RangeRepository rangeRepository, CheckSheetRepository checkSheetRepository) {
        this.rangeRepository = rangeRepository;
        this.checkSheetRepository = checkSheetRepository;
    }

    @GetMapping("")
    public String range(Model model) {
        model.addAttribute("title", "CheckSheet- Min Range");
        model.addAttribute("range", rangeRepository.findAll().get(0));
        return "range/range";
    }

    @PostMapping("update")
    String update(@Valid @ModelAttribute("range") JointRange range, BindingResult result,
                  HttpSession session, Model model, Principal principal) {
        try {
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while updating range {}", result);
                model.addAttribute("range", range);
                return "range/range";
            }
            JointRange updatedRange = rangeRepository.save(range);
            log.info("User with ID {}", principal.getName());
            log.info("CheckSheet updated successfully with id {}", updatedRange.getId());
            model.addAttribute("range", updatedRange);
            session.setAttribute("message", new Message("Successfully Updated Range", "alert-success"));
            return "redirect:/range";
        } catch (Exception ex) {
            log.info("User with ID {}", principal.getName());
            log.error("Error while updating range", ex);
            model.addAttribute("range", range);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "range/range";
        }
    }
}
