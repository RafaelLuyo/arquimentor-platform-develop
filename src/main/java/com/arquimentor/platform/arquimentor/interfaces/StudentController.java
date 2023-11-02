package com.arquimentor.platform.arquimentor.interfaces;


import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentByIdQuery;
import com.arquimentor.platform.arquimentor.domain.services.StudentCommandService;
import com.arquimentor.platform.arquimentor.domain.services.StudentQueryService;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import com.arquimentor.platform.arquimentor.interfaces.rest.transform.StudentResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Student Management Endpoints")
public class StudentController {
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;

    public StudentController(StudentQueryService studentQueryService, StudentCommandService studentCommandService) {
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandService.handle(createStudentCommand);
        if (studentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByIdQuery);

        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long studentId) {
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByIdQuery);
        if (student.isEmpty()) return ResponseEntity.badRequest().build();
        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }
}
