package com.arquimentor.platform.arquimentor.interfaces.acl;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByPhoneNumberQuery;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileCommandService;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileQueryService;

public class StudentProfileContextFacade {
    private final StudentProfileCommandService studentProfileCommandService;
    private final StudentProfileQueryService studentProfileQueryService;

    public StudentProfileContextFacade(
            StudentProfileCommandService studentProfileCommandService,
            StudentProfileQueryService studentProfileQueryService
    ) {
        this.studentProfileCommandService = studentProfileCommandService;
        this.studentProfileQueryService = studentProfileQueryService;
    }

    public Long createStudentProfile(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String description,
            String profilePhoto
    ) {
        CreateStudentProfileCommand createStudentProfileCommand = new CreateStudentProfileCommand(
                firstName,
                lastName,
                email,
                phoneNumber,
                description,
                profilePhoto
        );
        return studentProfileCommandService.handle(createStudentProfileCommand);
    }

    public Long getStudentProfileIdByPhoneNumber(String phoneNumber) {
        PhoneNumber phoneNumberObj = new PhoneNumber(phoneNumber);
        GetStudentProfileByPhoneNumberQuery query = new GetStudentProfileByPhoneNumberQuery(phoneNumberObj);
        return studentProfileQueryService
                .handle(query)
                .map(studentProfile -> studentProfile.getId())
                .orElse(0L);
    }
}
