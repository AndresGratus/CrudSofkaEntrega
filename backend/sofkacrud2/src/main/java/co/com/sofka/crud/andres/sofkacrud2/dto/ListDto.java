package co.com.sofka.crud.andres.sofkacrud2.todo;

import java.util.HashSet;
import java.util.Set;
/*
Los DTO son un tipo de objetos que sirven únicamente para transportar datos. EL DTO contiene las propiedades del objeto.
esta clase obtiene los datos para transferir a la tabla list
defino "private Set<TodoDto> todoList = new HashSet<>();" = La clase HashSet <T> proporciona operaciones de conjuntos
de alto rendimiento. Un conjunto es una colección que no contiene elementos duplicados y cuyos elementos no están en
un orden particular. (el mapeo de los datos to-do a la lista)
 */
public class ListDto {

    private Integer id;
    private String name;

    private Set<TodoDto> todoList = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TodoDto> getTodoList() {
        return todoList;
    }

    public void setTodoList(Set<TodoDto> todoList) {
        this.todoList = todoList;
    }
}