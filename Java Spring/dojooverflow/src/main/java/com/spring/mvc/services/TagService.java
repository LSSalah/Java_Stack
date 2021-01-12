package com.spring.mvc.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring.mvc.models.Tag;
import com.spring.mvc.repositories.TagRepository;



@Service
public class TagService {
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public ArrayList<Tag> findAllTags() {
		return (ArrayList<Tag>) tagRepo.findAll();
	}

	public Tag createTag(String tag) {
		return tagRepo.save(new Tag(tag));
		
	}
}