package com.spring.mvc.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mvc.models.Language;
import com.spring.mvc.repositories.LanguageRepository;
@Service
public class LanguageService {
    // adding the Language repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the Languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
//    public Language updateBook(Book b) {
//    	return languageRepository.save(b);
//    }
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	public Language updateLanguage(Long id, String name, String creator, Integer currentVersion) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		 if(optionalLanguage.isPresent()) {
			 Language language = optionalLanguage.get();
			 language.setName(name);
			 language.setCreator(creator);
			 language.setcurrentVersion(currentVersion);
	         languageRepository.save(language);
	         return language;
	        } else {
	            return null;
	        }
	}
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		 if(optionalLanguage.isPresent()) {
			 languageRepository.deleteById(id);
	        }
	}
}