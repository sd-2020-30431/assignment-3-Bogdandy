package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entities.*;

public interface UserRepository extends CrudRepository<User, Long>{

}
