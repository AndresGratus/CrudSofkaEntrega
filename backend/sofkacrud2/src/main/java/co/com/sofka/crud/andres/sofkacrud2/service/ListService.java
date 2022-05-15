package co.com.sofka.crud.andres.sofkacrud2.service;


import co.com.sofka.crud.andres.sofkacrud2.entity.List;
import co.com.sofka.crud.andres.sofkacrud2.repository.ListRepository;
import co.com.sofka.crud.andres.sofkacrud2.todo.ListDto;
import co.com.sofka.crud.andres.sofkacrud2.todo.ResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Este service guarda los datos de las listas, llamandolos desde los listDto (el id y el name) y los guarda en el repositorio.
 */

@Service
public class ListService {


    @Autowired
    private ListRepository listRepository;

    public ResponseDto list() {
        return new ResponseDto(listRepository.findAll(), "probando ejercicios");
    }

    public ResponseDto save(ListDto listDto) {
        //trae los datos del dto y los guarda en list
        List list = new List();
        list.setId(listDto.getId());
        list.setName(listDto.getName());
        list = listRepository.save(list);

        return new ResponseDto(list, "Se ha creado la lista correctamente");
    }

    //borrar lista
    public ResponseDto delete(ListDto listDto) {
        List list = new List();
        list.setId(listDto.getId());
        listRepository.delete(list);
        return new ResponseDto("ListTodo eliminado correctamente");
    }
    //borrar listapor id
    public ResponseDto deleteById(Integer id){
        listRepository.deleteById(id);
        return new ResponseDto("ListTodo eliminado correctamente");

    }

    public ResponseDto get(Integer id) {

        return new ResponseDto(listRepository.findById(id).orElseThrow());
    }

}