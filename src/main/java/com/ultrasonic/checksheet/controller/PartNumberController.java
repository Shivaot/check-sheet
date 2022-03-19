package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.PartNumber;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.PartNumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping("part-number")
public class PartNumberController {

    private final PartNumberRepository partNumberRepository;

    public PartNumberController(PartNumberRepository partNumberRepository) {
        this.partNumberRepository = partNumberRepository;
    }

    @RequestMapping("create")
    public String addPartNumber(Model model) {
        model.addAttribute("title", "CheckSheet - Create Part Number");
        model.addAttribute("partNumber", new PartNumber());
        return "part-number/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("PartNumber") PartNumber partNumber, BindingResult result,
                       HttpSession session, Model model, Principal principal) {

        try {
            PartNumber savedPartNumber = partNumberRepository.findByPartNumber(partNumber.getPartNumber());
            if(savedPartNumber != null){
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving part name {}", result);
                model.addAttribute("partNumber", partNumber);
                result.rejectValue("name", "error.partNumber", "PartNumber already present!");
                return "part-number/create";
            }
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving model {}", result);
                model.addAttribute("partNumber", partNumber);
                return "part-name/create";
            }
            partNumberRepository.save(partNumber);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin added Part Name with name {}", partNumber.getPartNumber());
            session.setAttribute("message", new Message("Successfully Added Part Name", "alert-success"));
            return "redirect:/part-number/list";
        } catch (Exception ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Error while saving part number", ex);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "part-number/create";
        }
    }

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("title", "CheckSheet - PartNumber List");
        model.addAttribute("partNumbers", partNumberRepository.findAll());
        return "part-number/list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@Param(value = "id") Long id, HttpSession session, Principal principal) {
        Optional<PartNumber> optionalPartNumber = partNumberRepository.findById(id);
        try {
            PartNumber partNumber = optionalPartNumber.get();
            partNumberRepository.delete(partNumber);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin deleted part number with id {}", id);
            session.setAttribute("message", new Message("Part Number deleted successfully with ID" + id, "alert-success"));
            return "redirect:/part-number/list";
        } catch (NoSuchElementException ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Part number not found ", ex);
            session.setAttribute("message", new Message("Part number Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }
}
