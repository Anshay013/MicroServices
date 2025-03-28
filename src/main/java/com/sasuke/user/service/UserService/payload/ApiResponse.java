package com.sasuke.user.service.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

// use Lombok for

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // for builder pattern

public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
