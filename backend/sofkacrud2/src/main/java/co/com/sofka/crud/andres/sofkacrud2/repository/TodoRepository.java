package co.com.sofka.crud.andres.sofkacrud2.repository;


import co.com.sofka.crud.andres.sofkacrud2.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}