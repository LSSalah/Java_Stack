package com.spring.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.models.Answer;
import com.spring.mvc.repositories.AnswerRepository;


@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	public Answer createAns(Answer answer) {
		return answerRepo.save(answer);
	}
	public List<Answer> getAll() {
		return answerRepo.findAll();
	}

}