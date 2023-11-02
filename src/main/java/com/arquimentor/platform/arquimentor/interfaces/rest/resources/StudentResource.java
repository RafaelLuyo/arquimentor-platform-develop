package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

public record StudentResource(
        Long id,
        String fullName,
        String email,

        String password
) {

}
