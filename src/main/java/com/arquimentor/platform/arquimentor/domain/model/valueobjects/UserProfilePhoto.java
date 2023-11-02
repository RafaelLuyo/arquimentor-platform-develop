package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import jakarta.persistence.Embeddable;


@Embeddable

public record UserProfilePhoto(
        @NonNull @Column(name = "profile_photo") String imageUrl
) {
    public UserProfilePhoto() {
        this(null);
    }


}