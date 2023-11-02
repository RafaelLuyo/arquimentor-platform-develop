package com.arquimentor.platform.arquimentor.interfaces.acl;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentCommand;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;
import com.arquimentor.platform.arquimentor.domain.services.StudentCommandService;
import com.arquimentor.platform.arquimentor.domain.services.StudentQueryService;

//capa de anticorrupción para comunicarse con otros bounden context
public class StudentContextFacade {
    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentContextFacade(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    public Long createStudent(String firstName,String lastName, String email, String password){
        var createStudentCommand = new CreateStudentCommand(firstName,lastName,email,password);
        return studentCommandService.handle(createStudentCommand);
    }

    public Long getStudentIdByEmail(String email){
        var getStudentByEmailQuery = (new GetStudentByEmailQuery(new EmailAddress(email)));
        var student = studentQueryService.handle(getStudentByEmailQuery);
        if(student.isEmpty())return 0L;
        return student.get().getId();
    }
}
