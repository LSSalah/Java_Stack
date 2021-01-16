package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Event;

@Repository
public interface EventRepo extends CrudRepository <Event, Long> {

}
