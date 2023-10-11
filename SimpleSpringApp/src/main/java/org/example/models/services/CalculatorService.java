package org.example.models.services;

import org.example.models.dto.CalculatorDTO;
import org.example.models.exceptions.IllegalCalculatorException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    /**
     * method which represents calculator service
     */
    public float calculate(CalculatorDTO calculator) {
        if (calculator.getOperation().equals("+")) {
            return calculator.getNumber1() + calculator.getNumber2();
        } else if (calculator.getOperation().equals("-")) {
            return calculator.getNumber1() - calculator.getNumber2();
        } else if ((calculator.getOperation().equals("*"))) {
            return calculator.getNumber1() * calculator.getNumber2();
        } else {
            if (calculator.getNumber2() == 0) {
                throw new IllegalCalculatorException("Second number cannot be 0!"); /* catching calculator exception */
            }
            return calculator.getNumber1() / calculator.getNumber2();
        }
    }
}
