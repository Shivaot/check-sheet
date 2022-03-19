package com.ultrasonic.checksheet.controller;

import com.ultrasonic.checksheet.domain.CheckSheet;
import com.ultrasonic.checksheet.domain.PartName;
import com.ultrasonic.checksheet.helper.Message;
import com.ultrasonic.checksheet.helper.Utils;
import com.ultrasonic.checksheet.repository.CheckSheetRepository;
import com.ultrasonic.checksheet.repository.RevisionRepository;
import com.ultrasonic.checksheet.service.CheckSheetService;
import com.ultrasonic.checksheet.service.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Shiva Created on 06/03/22
 */
@Slf4j
@Controller
@RequestMapping("check-sheet")
public class CheckSheetController {

    private final OperatorService operatorService;
    private final CheckSheetService checkSheetService;
    private final RevisionRepository revisionRepository;
    private final CheckSheetRepository checkSheetRepository;

    public CheckSheetController(OperatorService operatorService, CheckSheetService checkSheetService, RevisionRepository revisionRepository, CheckSheetRepository checkSheetRepository) {
        this.operatorService = operatorService;
        this.checkSheetService = checkSheetService;
        this.revisionRepository = revisionRepository;
        this.checkSheetRepository = checkSheetRepository;
    }

    @GetMapping("list")
    String list(Model model,
                @RequestParam("page") Optional<Integer> page,
                @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        Page<CheckSheet> checkSheetPage = operatorService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("checkSheetPage", checkSheetPage);
        model.addAttribute("checkSheets", checkSheetPage.getContent());

        int totalPages = checkSheetPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("title", "Checksheet List");
        return "checkSheet/list";
    }

    @GetMapping("show/{id}")
    String show(Model model, @PathVariable(value = "id") Long id, HttpSession session, Principal principal) {
        Optional<CheckSheet> optionalCheckSheet = checkSheetRepository.findById(id);
        String name = principal.getName();
        try {
            CheckSheet checkSheet = optionalCheckSheet.get();
            log.info("User with ID {}", name);
            log.info("User viewing checkSheet with id {}", id);
            model.addAttribute("title", "CheckSheet View");
            model.addAttribute("checkSheet", checkSheet);
            return "checkSheet/show";
        } catch (NoSuchElementException ex) {
            log.info("User with ID {}", name);
            log.error("CheckSheet not found ", ex);
            session.setAttribute("message", new Message("CheckSheet Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }

    @GetMapping("edit/{id}")
    String create(Model model, @PathVariable(value = "id") Long id ,Principal principal, HttpSession session) {
        Optional<CheckSheet> optionalCheckSheet = checkSheetRepository.findById(id);
        String name = principal.getName();
        try {
            CheckSheet checkSheet = optionalCheckSheet.get();
            log.info("User with ID {}", name);
            log.info("User editing checkSheet with id {}", id);
            model.addAttribute("title", "CheckSheet Edit");
            model.addAttribute("checkSheet", checkSheet);
            return "checkSheet/edit";
        } catch (NoSuchElementException ex) {
            log.info("User with ID {}", name);
            log.error("CheckSheet not found ", ex);
            session.setAttribute("message", new Message("CheckSheet Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }

    @PostMapping("update")
    String update(@Valid @ModelAttribute("checkSheet") CheckSheet checkSheet, BindingResult result,
                HttpSession session, Model model, Principal principal) {
        try {
            if (result.hasErrors()) {
                log.info("ADMIN with ID {}", principal.getName());
                log.error("Validation error while updating checkSheet {}", result);
                model.addAttribute("checkSheet", checkSheet);
                return "checkSheet/edit";
            }
            CheckSheet currentCheckSheet = checkSheetService.updateCheckSheet(checkSheet);
            log.info("User with ID {}", principal.getName());
            log.info("CheckSheet updated successfully with id {}", currentCheckSheet.getId());
            model.addAttribute("checkSheet", checkSheet);
            session.setAttribute("message", new Message("Successfully Updated CheckSheet", "alert-success"));
            return "redirect:show/"+currentCheckSheet.getId();
        } catch (Exception ex) {
            log.info("User with ID {}", principal.getName());
            log.error("Error while updating checkSheet", ex);
            model.addAttribute("checkSheet", checkSheet);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "checkSheet/edit";
        }
    }

    @GetMapping("report/{id}")
    public String report(@PathVariable("id") Long id) {
        return "checkSheet/chart";
    }

    @GetMapping("judgement/{id}")
    public String getJudgement(@PathVariable("id") Long id, Model model, HttpSession session, Principal principal) {
        Optional<CheckSheet> optionalCheckSheet = checkSheetRepository.findById(id);
        try {
            CheckSheet checkSheet = optionalCheckSheet.get();
            log.info("User viewing judgement with c-id {}", id);
            model.addAttribute("title", "Judgement View");
            model.addAttribute("checkSheet", checkSheet);
            model.addAttribute("sign", Utils.parseUsername(principal));
            return "checkSheet/judgement";
        } catch (NoSuchElementException ex) {
            log.error("CheckSheet not found ", ex);
            session.setAttribute("message", new Message("CheckSheet Not Found with ID " + id, "alert-danger"));
            return "error/404";
        }
    }

    @PostMapping("judgement/save")
    String saveJudgement(@Valid @ModelAttribute("checkSheet") CheckSheet checkSheet, BindingResult result,
                  HttpSession session, Model model, Principal principal) {
        try {
            if (result.hasErrors()) {
                log.info("User with ID {}", principal.getName());
                log.error("Validation error while updating judgement {}", result);
                model.addAttribute("checkSheet", checkSheet);
                return "checkSheet/judgement";
            }
            Optional<CheckSheet> optionalCheckSheet = checkSheetRepository.findById(checkSheet.getId());
            if (optionalCheckSheet.isPresent()) {

                CheckSheet savedCheckSheet = checkSheetService.updateWeldorNames(checkSheet, optionalCheckSheet);
                CheckSheet updatedCheckSheet = checkSheetRepository.save(savedCheckSheet);
                log.info("User with ID {}", principal.getName());
                log.info("CheckSheet judgement updated successfully with id {}", savedCheckSheet.getId());
                model.addAttribute("checkSheet", updatedCheckSheet);
                session.setAttribute("message", new Message("Successfully Updated Judgement", "alert-success"));
                return "redirect:/check-sheet/judgement/"+savedCheckSheet.getId();
            } else {
                log.info("User with ID {}", principal.getName());
                log.info("CheckSheet Not found for id {}", checkSheet.getId());
                session.setAttribute("message", new Message("CheckSheet Not found", "alert-danger"));
                return "error/404";
            }
        } catch (Exception ex) {
            log.info("User with ID {}", principal.getName());
            log.error("Error while updating checkSheet judgement", ex);
            model.addAttribute("checkSheet", checkSheet);
            session.setAttribute("message", new Message("Something went wrong!! " + ex.getMessage(), "alert-danger"));
            return "checkSheet/judgement";
        }
    }

}
