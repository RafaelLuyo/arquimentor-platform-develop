package com.arquimentor.platform.arquimentor.domain.model.commands;


public record CreateStudentCommand(String firstname, String lastname, String email, String password) {
}
