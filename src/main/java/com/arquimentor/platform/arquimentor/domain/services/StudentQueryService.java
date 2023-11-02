package com.arquimentor.platform.arquimentor.domain.services;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByEmailQuery;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;


public interface StudentQueryService {
    Optional<Student> handle(GetStudentByEmailQuery query);
    Optional<Student> handle(GetStudentByIdQuery query);
}
