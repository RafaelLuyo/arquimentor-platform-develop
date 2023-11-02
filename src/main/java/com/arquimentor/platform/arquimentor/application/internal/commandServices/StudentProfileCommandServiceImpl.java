package com.arquimentor.platform.arquimentor.application.internal.commandServices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileCommandService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileCommandServiceImpl implements StudentProfileCommandService {
    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileCommandServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public Long handle(CreateStudentProfileCommand command) {
        var phoneNumber = new PhoneNumber(command.phoneNumber());

        // Buscar un perfil de estudiante existente por número de teléfono
        studentProfileRepository.findByPhoneNumber(phoneNumber).ifPresent(existingStudentProfile -> {
            throw new IllegalArgumentException("Student with phoneNumber " + command.phoneNumber() + " already exists");
        });

        // Crear una instancia de Student
        Student student = new Student(command.firstname(), command.lastname(), command.email(), "password"); // Agrega una contraseña por defecto
        UserProfilePhoto userProfilePhoto = new UserProfilePhoto(command.profilePhoto());

        // Crear una instancia de StudentProfile con el objeto Student
        var studentProfile = new StudentProfile(student, command.firstname(), command.lastname(), command.email(), command.phoneNumber(), command.description(), userProfilePhoto);


        // Guardar el StudentProfile en el repositorio
        studentProfileRepository.save(studentProfile);

        return studentProfile.getId();
    }
}
