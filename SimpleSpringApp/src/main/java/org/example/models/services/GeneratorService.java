package org.example.models.services;


import org.example.models.dto.GeneratorDTO;
import org.example.models.exceptions.IllegalNumberGeneratorException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {

    /**
     * method which represents random number generator service
     */
    public int generate(GeneratorDTO generator) {
        Random random = new Random();

        if (generator.getMin() >= generator.getMax()) {
            throw new IllegalNumberGeneratorException(); /* Catching NumberGeneratorException when origin input is higher than bound */
        }
        return random.nextInt(generator.getMin(), generator.getMax() + 1); /* Setting the bound to +1 to include the second number */
    }

}
