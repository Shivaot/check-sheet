package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.PartName;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.PartNameRepository;
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
@RequestMapping("part-name")
public class PartNameController {

    private final PartNameRepository partNameRepository;

    public PartNameController(PartNameRepository partNumberRepository) {
        this.partNameRepository = partNumberRepository;
    }

    @RequestMapping("create")
    public String addModel(Model model) {
        model.addAttribute("title", "CheckSheet - Create Part Name");
        model.addAttribute("partName", new PartName());
        return "part-name/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("partName") PartName partName, BindingResult result,
                               HttpSession session, Model model, Principal principal) {

        try {
            PartName savedPartName = partNameRepository.findByName(partName.getName());
            if(savedPartName != null){
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving part name {}", result);
                model.addAttribute("partName", partName);
                result.rejectValue("name", "error.name", "PartName already present!");
                return "part-name/create";
            }
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving model {}", result);
                model.addAttribute("partName", partName);
                return "part-name/create";
            }
            partNameRepository.save(partName);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin added Part Name with name {}", partName.getName());
            session.setAttribute("message", new Message("Successfully Added Part Name", "alert-success"));
            return "redirect:/part-name/list";
        } catch (Exception ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Error while saving model", ex);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "part-name/create";
        }
    }

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("title", "CheckSheet - PartName List");
        model.addAttribute("partNames", partNameRepository.findAll());
        return "part-name/list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@Param(value = "id") Long id, HttpSession session, Principal principal) {
        Optional<PartName> optionalPartName = partNameRepository.findById(id);
        try {
            PartName partName = optionalPartName.get();
            partNameRepository.delete(partName);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin deleted part name with id {}", id);
            session.setAttribute("message", new Message("Model deleted successfully with ID" + id, "alert-success"));
            return "redirect:/part-name/list";
        } catch (NoSuchElementException ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Part name not found ", ex);
            session.setAttribute("message", new Message("Part name Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }
}
