package co.com.sofka.crud.andres.sofkacrud2.controller;

import co.com.sofka.crud.andres.sofkacrud2.exception.ValidationException;
import co.com.sofka.crud.andres.sofkacrud2.todo.ResponseDto;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value={ValidationException.class})
    public ResponseDto validationException(HttpServletResponse response, RuntimeException e){
        response.setStatus(400);
        return new ResponseDto(e.getMessage());
    }
    /*
    esta es la estructura para establecer las excepciones de la aplicacion. lo que hace es atrapar la excepcion: validationException y mostrarnos en pantalla un mensaje con el error.
    revisar el service: todoService
     */
}