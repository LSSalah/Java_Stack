package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Message;

@Repository
public interface MessageRepo extends CrudRepository <Message, Long>{

}