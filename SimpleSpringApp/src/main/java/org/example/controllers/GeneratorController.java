package org.example.controllers;

import org.example.models.dto.GeneratorDTO;
import org.example.models.services.GeneratorService;
import org.example.models.exceptions.IllegalNumberGeneratorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mapping set to /generator
 */
@Controller
@RequestMapping("/generator")
public class GeneratorController {

    /**
     * GeneratorController autowired to GeneratorService
     */
    @Autowired
    private GeneratorService generatorService;

    /**
     * method for rendering /generator page
     */
    @GetMapping
    public String renderGenerator(@ModelAttribute GeneratorDTO generatorDTO) {
        return "pages/generator";
    }

    /**
     * Generates random number based on range of numbers in GeneratorDTO
     *
     * @param generatorDTO The DTO containing the numbers
     * @param model        The Spring MVC Model object to add attributes to
     * @return The name of the view template to render
     */
    @PostMapping
    public String generate(@ModelAttribute GeneratorDTO generatorDTO, Model model) {
        try {
            int randomNumber = generatorService.generate(generatorDTO);
            model.addAttribute("result", randomNumber);
        } catch (IllegalNumberGeneratorException e) {
            model.addAttribute("error", "Number from can not be less than number to.");
        }
        return "pages/generator";
    }


}
