package com.Lesson4EndProject.com.Lesson4EndProject.repository;

import java.util.List;

import com.Lesson4EndProject.com.Lesson4EndProject.controller.Library;

public interface LibraryRepositoryCustom {

	
	List<Library>findAllByAuthor(String authorName);
	
	
}
