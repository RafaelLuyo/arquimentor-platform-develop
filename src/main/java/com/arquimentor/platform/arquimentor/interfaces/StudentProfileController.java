package com.arquimentor.platform.arquimentor.interfaces;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByPhoneNumberQuery;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileCommandService;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileQueryService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateStudentProfileCommandFromResourceAssembler;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.StudentProfileResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student-profiles")
public class StudentProfileController {

    private final StudentProfileQueryService studentProfileQueryService;
    private final StudentProfileCommandService studentProfileCommandService;

    public StudentProfileController(
            StudentProfileQueryService studentProfileQueryService,
            StudentProfileCommandService studentProfileCommandService) {
        this.studentProfileQueryService = studentProfileQueryService;
        this.studentProfileCommandService = studentProfileCommandService;
    }

    @PostMapping
    public ResponseEntity<StudentProfileResource> createStudentProfile(@RequestBody CreateStudentProfileResource resource) {
        CreateStudentProfileCommand command = CreateStudentProfileCommandFromResourceAssembler.toCommandFromResource(resource);

        // Convierte la cadena de número de teléfono en un objeto PhoneNumber
        PhoneNumber phoneNumber = new PhoneNumber(resource.phoneNumber());

        GetStudentProfileByPhoneNumberQuery query = new GetStudentProfileByPhoneNumberQuery(phoneNumber);
        StudentProfile studentProfile = studentProfileQueryService.handle(query).orElse(null);

        if (studentProfile == null) {
            return ResponseEntity.badRequest().build();
        }

        StudentProfileResource studentProfileResource = StudentProfileResourceFromEntityAssembler.toResourceFromEntity(studentProfile);

        return new ResponseEntity<>(studentProfileResource, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfileResource> getStudentProfile(@PathVariable Long id) {
        StudentProfile studentProfile = studentProfileQueryService.findById(id).orElse(null);

        if (studentProfile == null) {
            return ResponseEntity.notFound().build();
        }

        StudentProfileResource studentProfileResource = StudentProfileResourceFromEntityAssembler.toResourceFromEntity(studentProfile);

        return ResponseEntity.ok(studentProfileResource);
    }
}