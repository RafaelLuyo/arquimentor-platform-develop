package com.arquimentor.platform.arquimentor.domain.exceptions;

public class StudentNotExceptions extends RuntimeException{
     public StudentNotExceptions(){
        super("Students not found");
    }
}
