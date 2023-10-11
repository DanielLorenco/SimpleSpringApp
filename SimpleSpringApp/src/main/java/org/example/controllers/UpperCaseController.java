package org.example.controllers;

import org.example.models.dto.UpperCaseDTO;
import org.example.models.services.UpperCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mapping set to /uppercase
 */
@Controller
@RequestMapping("/uppercase")
public class UpperCaseController {

    /**
     * UpperCaseController autowired to UpperCaseService
     */
    @Autowired
    private UpperCaseService upperCaseService;

    /**
     * method for rendering /makeituppercase page
     */
    @GetMapping
    public String renderUpperCase(@ModelAttribute UpperCaseDTO upperCaseDTO) {

        return "pages/makeituppercase";
    }

    /**
     * Transfers the input text provided by upperCaseDTO to upperCase
     *
     * @param upperCaseDTO The DTO containing the text.
     * @param model        The Spring MVC Model object to add attributes to.
     * @return The name of the view template to render.
     */
    @PostMapping
    public String toUpperCase(@ModelAttribute UpperCaseDTO upperCaseDTO, Model model) {

        String result = upperCaseService.toUpperCase(upperCaseDTO);
        model.addAttribute("result", result);
        return "pages/makeituppercase";

    }


}



