package co.com.sofka.crud.andres.sofkacrud2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Entity
public class ListEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //genera ID automático
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.EAGER)
    private Set<TodoEntity> toDos;

    public ListEntity() {
    }
    public ListEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}