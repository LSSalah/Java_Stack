package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.UserShow;

@Repository
public interface UserShowRepo extends CrudRepository<UserShow, Long> {

}