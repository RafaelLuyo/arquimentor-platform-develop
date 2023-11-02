package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

public record CreateStudentResource(
        String firstName,
        String lastname,
        String email,
        String password
) {

}
