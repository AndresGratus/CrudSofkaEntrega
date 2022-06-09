package co.com.sofka.crud.andres.sofkacrud2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
esta es la tabla de los to-dos
le coloco @column con length 15 para que el nombre no pase de 15 caracteres y nullable false, para que no se crean listas vacias.
le coloco al atributo completed un @column: columnDefinition =0 para definirle a la base de datos que retorne un 0 si falso, o
1 si verdadero.
Coloco un @JsonBackReference Para cuando vaya a responder en el navegador No mapee o no pinte ese atributo Ya que
se crea una dependencia circular.
Coloco el ManyToOne para que se referencie los to-dos a la list
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //permite generar automáticamente el ID
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_list")
    private ListEntity list;
}