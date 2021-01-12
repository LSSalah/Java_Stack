package com.spring.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mvc.models.Question;
import com.spring.mvc.repositories.QuestionRepository;


@Service
public class QuestionService {
	private final QuestionRepository questionRepo;
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}

	public Question findQ(Long id) {
		Optional<Question> myQ = questionRepo.findById(id);
		if (myQ.isPresent()) {
			return myQ.get();
		}else {
			return null;
		}
	}
	public List<Question> findAll(){
		return questionRepo.findAll();
	}
}