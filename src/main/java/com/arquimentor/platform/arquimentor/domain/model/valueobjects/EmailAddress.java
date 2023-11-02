package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Embeddable
public record EmailAddress(
        @Email  String address
) {

     public EmailAddress(){
         this(null);
     }
}
