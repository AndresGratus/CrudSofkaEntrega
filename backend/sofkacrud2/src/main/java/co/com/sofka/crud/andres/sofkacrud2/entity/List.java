package co.com.sofka.crud.andres.sofkacrud2.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/*
Esta es la tabla que crea las listas.
tiene la relacion OneToMany mapeada por list. no le coloco el cascade.All, para que a la entidad
no le aploque la operacion de la base de datos. es decir, que en caso de que actualice el nombre de la lista(por ejemplo),
no me actualice tambien las tareas que tiene dentro de la lista. recordar que se borraban los to-do que le ponia cuando actualizaba el nombre.
le coloco @column con length 15 para que el nombre no pase de 15 caracteres y nullable false, para que no se crean listas vacias.
que es HashSet: En resumidas líneas la clase HashSet es aquella que implementa la interfaz Set que respaldada por una
tabla hash en realidad es una instancia de HashMap. ... HashSet contiene un conjunto de objetos, pero de una manera
que le permite determinar fácil y rápidamente si un objeto ya está en el conjunto o no.
 */

@Table(name = "list")
@Entity()
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "list")
    private Set<Todo> todoList = new HashSet<>();

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

    public Set<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(Set<Todo> todoList) {
        this.todoList = todoList;
    }

    public void addTodoList(Todo todo) {
        this.todoList.add(todo);

    }
}