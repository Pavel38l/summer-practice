package ru.example.bookreview.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.example.bookreview.dto.MsgDto;

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
