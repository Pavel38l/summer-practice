package ru.example.bookstore.controller;

import ru.example.bookstore.dto.MsgDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @CrossOrigin
    public MsgDto runtimeExceptionHandler(Exception e) {
        return new MsgDto(e.getMessage());
    }
}
