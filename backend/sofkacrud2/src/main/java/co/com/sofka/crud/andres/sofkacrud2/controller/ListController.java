package co.com.sofka.crud.andres.sofkacrud2.controller;


import co.com.sofka.crud.andres.sofkacrud2.entity.ListEntity;
import co.com.sofka.crud.andres.sofkacrud2.service.ListService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
CRUD de list
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ListController {


    @Autowired
    ListService listservice;

    @GetMapping(value = "/list")
    public ResponseEntity<List<ListEntity>> getAllList() {
        List<ListEntity> allList = listservice.getAllList();
        if (allList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }


    @GetMapping(value = "/list/{id}")
    public ResponseEntity<ListEntity> getListById(@PathVariable("id") Long id){
        Optional<ListEntity> listData = listservice.getListById(id);
        if(listData.isPresent()){
            return new ResponseEntity<>(listData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/list")
    //manejamos la respuesta HTTP y RequestBody sirve para deserializar un objeto
    public ResponseEntity<ListEntity> saveList(@RequestBody ListEntity list){
        try {
            ListEntity newList= listservice.saveList(list);
            return new ResponseEntity<>(newList, HttpStatus.CREATED);
        } catch(Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/list/{id}")
    public ResponseEntity<ListEntity> updateList(@PathVariable("id") long id, @RequestBody ListEntity list){
        try {
            ListEntity newList= listservice.updateList(id, list);
            return new ResponseEntity<>(newList, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar la lista");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping(value = "list/{id}")
    public ResponseEntity<String> deleteListById(@PathVariable("id")Long id){
        try {
            listservice.deleteListById(id);
            return new ResponseEntity<>("Lista eliminada", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}