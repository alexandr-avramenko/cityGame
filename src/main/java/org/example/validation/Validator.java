package org.example.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private final List<String> allowedCitiesList;

    public Validator(List<String> allowedCitiesList) {
        this.allowedCitiesList = allowedCitiesList;
    }

    private boolean isValidCity(String city) {
        return this.allowedCitiesList.contains(city);
    }


}
