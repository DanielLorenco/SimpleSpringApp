package org.example.controllers;

import org.example.models.dto.GeneratorDTO;
import org.example.models.dto.UpperCaseDTO;
import org.example.models.dto.CalculatorDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String renderIndex() {
        return "pages/index";

    }
/*
    @GetMapping("/generator")
    public String renderGenerator(@ModelAttribute GeneratorDTO generatorDTO) {
        return "pages/generator";
    }
        @GetMapping("/uppercase")
        public String renderUpperCase(@ModelAttribute UpperCaseDTO upperCaseDTO) {

            return "pages/makeituppercase";
        }

        @GetMapping("/calculator")
        public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
            return "pages/calculator";
        }


 */
}
