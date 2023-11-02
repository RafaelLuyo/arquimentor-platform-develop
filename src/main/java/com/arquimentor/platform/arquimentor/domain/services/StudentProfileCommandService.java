package com.arquimentor.platform.arquimentor.domain.services;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
public interface StudentProfileCommandService {
    Long handle(CreateStudentProfileCommand command);
}
