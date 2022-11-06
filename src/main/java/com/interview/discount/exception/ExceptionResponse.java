package com.interview.discount.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "ExceptionResponse", description = "Respuesta de error")
public class ExceptionResponse {


    private HttpStatus httpStatus;

    private String code;

    private LocalDateTime timestamp;

    private String message;

    private Object details;
}
