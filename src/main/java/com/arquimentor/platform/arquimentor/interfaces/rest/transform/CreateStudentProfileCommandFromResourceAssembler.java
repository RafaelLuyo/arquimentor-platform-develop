package com.arquimentor.platform.arquimentor.interfaces.rest.transform;


import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentProfileResource;


public class CreateStudentProfileCommandFromResourceAssembler {
    public static CreateStudentProfileCommand toCommandFromResource(CreateStudentProfileResource resource){
        return new CreateStudentProfileCommand(resource.firstName(),resource.lastname(),resource.email(),resource.phoneNumber(),resource.description(), resource.profilePhoto());
    }
}
