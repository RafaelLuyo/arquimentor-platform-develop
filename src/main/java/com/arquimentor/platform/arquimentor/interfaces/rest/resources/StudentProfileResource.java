package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

public record StudentProfileResource(  Long id,
                                       String fullName,
                                       String email,
                                       String phoneNumber,
                                       String description,
                                       String profilePhoto)
{
}
