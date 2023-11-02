package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class StudentProfile extends AbstractAggregateRoot<StudentProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    @Embedded
    private StudentName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "email"))
    })
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "phone_number"))
    })
    private PhoneNumber phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description"))
    })
    private Description description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "profile_photo"))
    })
    private UserProfilePhoto profilePhoto;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
    public StudentProfile(Student student, String firstName, String lastName, String email, String phoneNumber, String description, UserProfilePhoto profilePhoto) {
        this.student = student;
        this.name = new StudentName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.description = new Description(description);
        this.profilePhoto = profilePhoto;
    }

    public StudentProfile() {

    }

    // Otros constructores y métodos

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateDescription(String description) {
        this.description = new Description(description);
    }

    public String getStudentName() {
        return this.name.getFullName();
    }

    public String getEmailAddress() {
        return this.email.address();
    }

    public String getPhoneNumber() {
        return this.phoneNumber.value();
    }
    public Long getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description.value();
    }

    public String getProfilePhotoUrl() {
        return this.profilePhoto.imageUrl();
    }
}
