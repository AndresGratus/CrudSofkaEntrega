package co.com.sofka.crud.andres.sofkacrud2.service;



import co.com.sofka.crud.andres.sofkacrud2.entity.ListEntity;
import co.com.sofka.crud.andres.sofkacrud2.repository.ListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Este service guarda los datos de las listas, llamandolos desde los listDto (el id y el name) y los guarda en el repositorio.
 */

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ListService {

    @Autowired
    ListRepository listRepository;

    public ArrayList<ListEntity> getAllList(){
        return (ArrayList<ListEntity>) listRepository.findAll();
    }


    public ListEntity saveList(ListEntity list){
        return listRepository.save(list);
    }

    public Optional<ListEntity> getListById(Long id){
        return listRepository.findById(id);
    }


    public void deleteListById(Long id){
        Optional<ListEntity> currentList = listRepository.findById(id); // se comporta como wraper evitamos que el método nos devuelva null
        if(currentList.isPresent()){
            ListEntity _currentlist = currentList.get();
            listRepository.delete(_currentlist);
        }else {
            throw new RuntimeException("No existe lista para borrar");
        }
    }


    public ListEntity updateList(Long id, ListEntity list){
        Optional<ListEntity> currentList = listRepository.findById(id);
        if(currentList.isPresent()){
            ListEntity _list = currentList.get();
            _list.setName(list.getName());
            return listRepository.save(_list);
        }
        throw new RuntimeException("No existe lista para actualizar");
    }
}