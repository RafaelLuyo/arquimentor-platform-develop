package com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByPhoneNumber(PhoneNumber phoneNumber);

    Optional<StudentProfile> findById(Long studentProfileId);
}
