package com.arquimentor.platform.arquimentor.domain.model.commands;



public record CreateStudentProfileCommand(
        String firstname,
        String lastname,
        String email,
        String phoneNumber,
        String description,
        String profilePhoto
) {

}
