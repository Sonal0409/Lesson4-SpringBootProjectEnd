package com.Lesson4EndProject.com.Lesson4EndProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lesson4EndProject.com.Lesson4EndProject.controller.Library;
import com.Lesson4EndProject.com.Lesson4EndProject.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository repository;
	
	public String buildId(String isbn, int aisle)
	{
		if(isbn.startsWith("Z"))
		{
			return "OLD"+isbn+aisle;
		}
		return isbn+aisle;
	}
	
	public boolean checkBookAlreadyexist(String id)
	{
		Optional<Library>lib = repository.findById(id);
		if(lib.isPresent())
		
			return true;
		else
			return false;
		
	}
	

}
