package co.com.sofka.crud.andres.sofkacrud2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
/*
esta es la tabla de los to-dos
le coloco @column con length 15 para que el nombre no pase de 15 caracteres y nullable false, para que no se crean listas vacias.
le coloco al atributo completed un @column: columnDefinition =0 para definirle a la base de datos que retorne un 0 si falso, o
1 si verdadero.
Coloco un @JsonBackReference Para cuando vaya a responder en el navegador No mapee o no pinte ese atributo Ya que
se crea una dependencia circular.
Coloco el ManyToOne para que se referencie los to-dos a la list
 */
@Table(name = "todo")
@Entity()
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(columnDefinition = "0")
    private boolean completed;

    @JsonBackReference
    @ManyToOne(targetEntity = List.class)
    private List list;

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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}