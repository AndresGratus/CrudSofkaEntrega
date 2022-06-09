package co.com.sofka.crud.andres.sofkacrud2.controller;


import co.com.sofka.crud.andres.sofkacrud2.entity.TodoEntity;
import co.com.sofka.crud.andres.sofkacrud2.service.TodoService;
import co.com.sofka.crud.andres.sofkacrud2.dto.ToDoListDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
CRUD de to-dos
 */

@RestController
@CrossOrigin( "http://localhost:3000" )
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping(value = "/todos")
    public List<ToDoListDTO> getAllTodoS(){
        return todoService.getAllTodosWithList();
    }


    @PostMapping(value = "/todo")
    public ResponseEntity<ToDoListDTO> saveToDo(@RequestBody ToDoListDTO todo ){
        try {
            ToDoListDTO newToDo = todoService.saveToDo(todo);
            return  new ResponseEntity<>(newToDo, HttpStatus.CREATED);
        }catch (Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }


    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable("id") long id, @RequestBody TodoEntity todo){
        try {
            TodoEntity newToDo= todoService.updateTodo(id, todo);
            return new ResponseEntity<>(newToDo, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar todo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoEntity> getTodobyId(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>(todoService.getToDoById(id),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(todoService.deleteToDoById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}