package com.atm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atm.model.User;

public interface UserRespository extends MongoRepository<User, Long>{

}
