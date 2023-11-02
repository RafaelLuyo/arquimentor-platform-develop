package com.arquimentor.platform.arquimentor.domain.model.queries;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;

public record GetStudentByEmailQuery(EmailAddress emailAddress) {

}
