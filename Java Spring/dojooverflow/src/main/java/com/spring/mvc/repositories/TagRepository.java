package com.spring.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Tag;


@Repository
public interface TagRepository extends CrudRepository <Tag, Long> {

}