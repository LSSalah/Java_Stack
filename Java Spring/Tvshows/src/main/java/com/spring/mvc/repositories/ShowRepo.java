package com.spring.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.models.Show;

@Repository
public interface ShowRepo extends CrudRepository <Show, Long> {
	List<Show> findAll();
	Show findByTitle(String title);
	Show findByNetwork(String network);
}