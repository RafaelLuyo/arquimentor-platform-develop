package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.exceptions.StudentNotExceptions;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentCommand;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;
import com.arquimentor.platform.arquimentor.domain.services.StudentCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateStudentCommand command) {
        var emailAddress = new EmailAddress(command.email());
        studentRepository.findByEmail(emailAddress)
                .map(student -> {
                    throw new IllegalArgumentException("Studdent whit email"+ command.email()+" already exists");
                });
        var student = new Student(command.firstname(),command.firstname(),command.email(),command.password());
        studentRepository.save(student);
        return student.getId();
    }
}
