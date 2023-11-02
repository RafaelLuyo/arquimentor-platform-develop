package com.arquimentor.platform.arquimentor.application.internal.queryservices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByPhoneNumberQuery;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileQueryService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentProfileQueryServiceImpl implements StudentProfileQueryService {
    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileQueryServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query) {
        return studentProfileRepository.findByPhoneNumber(query.phoneNumber());
    }

    @Override
    public Optional<StudentProfile> findById(Long studentProfileId) {
        return studentProfileRepository.findById(studentProfileId);
    }
}
