package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.CheckSheetModel;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.repository.CheckSheetModelRepository;
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
@RequestMapping("model")
public class CheckSheetModelController {

    private final CheckSheetModelRepository checkSheetModelRepository;

    public CheckSheetModelController(CheckSheetModelRepository checkSheetModelRepository) {
        this.checkSheetModelRepository = checkSheetModelRepository;
    }

    @RequestMapping("create")
    public String create(Model model) {
        model.addAttribute("title", "Checksheet - Create Model");
        model.addAttribute("model", new CheckSheetModel());
        return "model/create";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("model") CheckSheetModel checkSheetModel, BindingResult result,
                               HttpSession session, Model model, Principal principal) {

        try {
            CheckSheetModel savedModel = checkSheetModelRepository.findByModelName(checkSheetModel.getModelName());
            if(savedModel != null){
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving model {}", result);
                model.addAttribute("model", checkSheetModel);
                result.rejectValue("modelName", "error.modelName", "Model already present!");
                return "model/create";
            }
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while saving model {}", result);
                model.addAttribute("model", checkSheetModel);
                return "model/create";
            }
            checkSheetModelRepository.save(checkSheetModel);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin added Model with name {}", checkSheetModel.getModelName());
            session.setAttribute("message", new Message("Successfully Added Model", "alert-success"));
            return "redirect:/model/list";
        } catch (Exception ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Error while saving model", ex);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "model/create";
        }
    }

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("title", "CheckSeet - Models List");
        model.addAttribute("models", checkSheetModelRepository.findAll());
        return "model/list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteModel(@Param(value = "id") Long id, HttpSession session, Principal principal) {
        Optional<CheckSheetModel> checkSheetModel = checkSheetModelRepository.findById(id);
        try {
            CheckSheetModel sheetModel = checkSheetModel.get();
            checkSheetModelRepository.delete(sheetModel);
            log.info("ADMIN with ID {}", principal.getName());
            log.info("Admin deleted model with id {}", id);
            session.setAttribute("message", new Message("Model deleted successfully with ID" + id, "alert-success"));
            return "redirect:/model/list";
        } catch (NoSuchElementException ex) {
            log.info("ADMIN with ID {}", principal.getName());
            log.error("Model not found ", ex);
            session.setAttribute("message", new Message("Model Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }
}
