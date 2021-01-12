package com.spring.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Answer;


@Repository
public interface AnswerRepository extends CrudRepository <Answer, Long> {
	List<Answer> findAll();
}