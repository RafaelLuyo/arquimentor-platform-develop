package com.arquimentor.platform.arquimentor.interfaces.rest.resources;

public record CreateStudentProfileResource( String firstName,
                                            String lastname,
                                            String email,
                                            String phoneNumber,
                                            String description,
                                            String profilePhoto)
{

}

