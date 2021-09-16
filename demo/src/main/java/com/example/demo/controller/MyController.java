package com.example.demo.controller;

import com.example.demo.model.Model;
import com.example.demo.repo.MyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    MyInterface myInterface;

    @PostMapping("/insert")
    public Model addModel(@RequestBody Model model){
        myInterface.save(model);
        return model;
    }

    @GetMapping("/getAll")
    public List<Model> getAllModel(){
        return myInterface.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Model> getModel(@PathVariable String id){
        Optional<Model> byId = myInterface.findById(id);
        if (byId.isPresent()) {
            Model model = byId.get();
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        else{
            throw new RuntimeException("id not found");
        }

    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable String id){
        myInterface.deleteById(id);
        return "successfully deleted";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        myInterface.deleteAll();
        return "Deleted successfully";
    }

}
