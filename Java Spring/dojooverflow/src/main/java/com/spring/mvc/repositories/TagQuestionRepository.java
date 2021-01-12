package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.TagQuestion;


@Repository
public interface TagQuestionRepository extends CrudRepository <TagQuestion, Long> { 

}