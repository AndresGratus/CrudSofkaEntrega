package co.com.sofka.crud.andres.sofkacrud2.controller;


import co.com.sofka.crud.andres.sofkacrud2.service.TodoService;
import co.com.sofka.crud.andres.sofkacrud2.dto.ResponseDto;
import co.com.sofka.crud.andres.sofkacrud2.dto.TodoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
CRUD de to-dos
 */

@RestController
@CrossOrigin( "http://localhost:3000" )
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping()
    public ResponseDto addTodo(@RequestBody TodoDto todoDto){

        return todoService.saveTodo(todoDto);

    }
    @PutMapping()
    public ResponseDto updateTodo(@RequestBody TodoDto todoDto){
        return todoService.updateTodo(todoDto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteById(@PathVariable("id") Integer id) {
        return todoService.deleteById(id);
    }

    @GetMapping()
    public ResponseDto getTodo() {
        return todoService.todo();
    }

    @GetMapping(value = "/{id}")
    public ResponseDto get(@PathVariable("id") Integer id) {
        return todoService.get(id);
    }

}