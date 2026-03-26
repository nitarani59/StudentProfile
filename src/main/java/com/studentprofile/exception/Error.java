package com.studentprofile.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
public class Error {
    private HttpStatusCode errorCode;
    private String errorMessage;

}
