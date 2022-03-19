package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.CheckSheet;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.CheckSheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


/**
 * Shiva Created on 05/03/22
 */
@Slf4j
@Controller
@RequestMapping("operator")
public class OperatorController {

    private final CheckSheetRepository checkSheetRepository;

    public OperatorController(CheckSheetRepository checkSheetRepository) {
        this.checkSheetRepository = checkSheetRepository;
    }

    @GetMapping("check-sheet/create")
    String create(Model model, Principal principal) {
        CheckSheet checkSheet = new CheckSheet();
        model.addAttribute("title", "Create Checksheet");
        model.addAttribute("checkSheet", checkSheet);
        return "checkSheet/create";
    }

    @PostMapping("check-sheet/save")
    String save(@Valid @ModelAttribute("checkSheet") CheckSheet checkSheet, BindingResult result,
                HttpSession session, Model model, Principal principal) {
        try {
            if (result.hasErrors()) {
                log.info("Operator with ID {}", principal.getName());
                log.error("Validation error while saving checkSheet {}", result);
                model.addAttribute("checkSheet", checkSheet);
                return "checkSheet/create";
            }
            checkSheet.setInspector(principal.getName());
            checkSheet.setIsCurrentRevision(true);
            CheckSheet savedCheckSheet = checkSheetRepository.save(checkSheet);
            log.info("Operator with ID {}", principal.getName());
            log.info("CheckSeet saved successfully with id {}", savedCheckSheet.getId());
            model.addAttribute("checkSheet", checkSheet);
            session.setAttribute("message", new Message("Successfully Added CheckSheet ID: " + savedCheckSheet.getId(), "alert-success"));
        } catch (Exception ex) {
            log.info("Operator with ID {}", principal.getName());
            log.error("Error while saving checkSheet", ex);
            model.addAttribute("checkSheet", checkSheet);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "checkSheet/create";
        }
        return "redirect:/check-sheet/list";
    }


}
