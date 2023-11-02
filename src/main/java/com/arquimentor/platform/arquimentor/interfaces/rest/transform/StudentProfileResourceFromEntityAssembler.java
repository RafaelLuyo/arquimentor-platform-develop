package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentResource;

public class StudentProfileResourceFromEntityAssembler {
    public static StudentProfileResource toResourceFromEntity(StudentProfile entity){

        return new StudentProfileResource(entity.getId(),entity.getStudentName(),entity.getEmailAddress(),entity.getPhoneNumber(),entity.getDescription(), entity.getProfilePhotoUrl());
    }
}
