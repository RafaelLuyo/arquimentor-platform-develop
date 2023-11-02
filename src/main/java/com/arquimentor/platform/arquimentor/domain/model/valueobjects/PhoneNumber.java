package com.arquimentor.platform.arquimentor.domain.model.valueobjects;



import lombok.Getter;



public record PhoneNumber(String value) {
    public PhoneNumber {
        if (value == null || value.length() != 9 || !value.matches("\\d+")) {
            throw new IllegalArgumentException("El número de teléfono debe tener exactamente 9 dígitos.");
        }
    }
}
