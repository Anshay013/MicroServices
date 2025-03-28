package com.sasuke.user.service.UserService.exceptions;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException (){
        super("Resource not found not server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
