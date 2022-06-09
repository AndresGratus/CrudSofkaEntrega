package co.com.sofka.crud.andres.sofkacrud2.service;


import co.com.sofka.crud.andres.sofkacrud2.entity.TodoEntity;
import co.com.sofka.crud.andres.sofkacrud2.dto.ToDoListDTO;


import co.com.sofka.crud.andres.sofkacrud2.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Este service guarda los datos de los to-dos, llamandolos desde los todoDto (el id, el name y el completed)
y los guarda en el repositorio.
define las excepciones en el caso de actualizarse los datos
*/


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TodoService {


    @Autowired
    TodoRepository todoRepository;

    @Autowired
    ModelMapper mapper;

    public List<ToDoListDTO> getAllTodosWithList(){
        return todoRepository.findAll().
                stream().
                map(this::convertEntityToDto). //method reference
                        collect(Collectors.toList());
    }


    private ToDoListDTO convertEntityToDto(TodoEntity todo){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);//permite coincidir solo la última propiedad de jerarquía
        ToDoListDTO todoDto = new ToDoListDTO(); //creamos nuestro DTO
        todoDto = mapper.map(todo, ToDoListDTO.class); //plantilla de creación de objetos
        return todoDto;
    }


    public ToDoListDTO saveToDo(ToDoListDTO todo) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TodoEntity todoEnt = new TodoEntity();
        todoEnt = mapper.map(todo, TodoEntity.class);
        if(todoEnt.getList() == null){
            throw new RuntimeException("La lista no puede ser vacía cuando se crea un todo");}
        TodoEntity hola = todoRepository.save(todoEnt);
        return mapper.map(hola, ToDoListDTO.class);
    }


    //Metodo para obtener toDos por id
    public TodoEntity getToDoById(Long id){
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new RuntimeException("No existe todo");
        }
    }

    public TodoEntity updateTodo(long id, TodoEntity todo){
        Optional<TodoEntity> currentTodo = todoRepository.findById(id);

        if (currentTodo.isPresent()){
            TodoEntity _currentTodo = currentTodo.get();
            long currentList = _currentTodo.getList().getId();
            long newTodoListId = todo.getList().getId();
            if(currentList != newTodoListId){
                throw new RuntimeException("Cambiar la lista está prohibido");
            }
        }
        if(todo.getId() != null){
            return todoRepository.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }


    public String deleteToDoById(Long id){
        Optional<TodoEntity> currentTodoById = todoRepository.findById(id);
        if (currentTodoById.isPresent()){
            TodoEntity _currentTodo = currentTodoById.get();
            todoRepository.delete(_currentTodo);
            return "ToDo eliminado";
        } else {
            throw new RuntimeException("No existe el todo a eliminar");
        }
    }
}