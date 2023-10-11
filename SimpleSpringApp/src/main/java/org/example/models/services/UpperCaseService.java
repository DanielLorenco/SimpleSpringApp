package org.example.models.services;

import org.example.models.dto.UpperCaseDTO;
import org.springframework.stereotype.Service;

@Service
public class UpperCaseService {

    /**
     * method which represents uppercase service
     */
    public String toUpperCase(UpperCaseDTO model) {

        return model.getText().toUpperCase();
    }
}
