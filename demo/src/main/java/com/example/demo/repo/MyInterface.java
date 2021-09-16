package com.example.demo.repo;

import com.example.demo.model.Model;
import org.springframework.boot.Banner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyInterface extends MongoRepository<Model, String> {

}
