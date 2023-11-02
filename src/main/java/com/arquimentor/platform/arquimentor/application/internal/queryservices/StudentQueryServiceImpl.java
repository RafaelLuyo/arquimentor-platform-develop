package com.arquimentor.platform.arquimentor.application.internal.queryservices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.arquimentor.domain.services.StudentQueryService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByEmailQuery query) {
        return studentRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Student> handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.StudentId());
    }
}
