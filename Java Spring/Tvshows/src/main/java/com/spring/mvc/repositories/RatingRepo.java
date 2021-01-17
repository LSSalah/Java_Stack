package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Rating;

@Repository
public interface RatingRepo extends CrudRepository <Rating, Long>{
}