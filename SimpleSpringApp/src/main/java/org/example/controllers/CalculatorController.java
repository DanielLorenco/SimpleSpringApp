package org.example.controllers;

import org.example.models.dto.CalculatorDTO;
import org.example.models.exceptions.IllegalCalculatorException;

import org.example.models.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mapping set to /calculator
 */
@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    /**
     * CalculatorController class autowired to CalculatorService
     */
    @Autowired
    private CalculatorService calculatorService;

    /**
     * method for rendering calculator page
     */
    @GetMapping
    public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        return "pages/calculator";
    }

    /**
     * Calculates the result of a mathematical operation based on the provided CalculatorDTO.
     *
     * @param calculatorDTO The DTO containing the numbers and operation.
     * @param model         The Spring MVC Model object to add attributes to.
     * @return The name of the view template to render.
     */
    @PostMapping
    public String calculate(CalculatorDTO calculatorDTO, Model model) {
        try {
            float result = calculatorService.calculate(calculatorDTO);
            model.addAttribute("result", result);
        } catch (IllegalCalculatorException e) {
            model.addAttribute("error", "You can not divide by 0!");
        }
        return "pages/calculator";
    }


}