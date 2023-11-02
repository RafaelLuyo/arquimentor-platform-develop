package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource){
        return new CreateStudentCommand(resource.firstName(),resource.firstName(),resource.email(),resource.password());
    }
}
