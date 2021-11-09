package com.Lesson4EndProject.com.Lesson4EndProject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Lesson4EndProject.com.Lesson4EndProject.controller.Library;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{

	@Autowired
	LibraryRepository repository;
	
	@Override
	public List<Library> findAllByAuthor(String authorName) {
		
		List<Library>	bookswithAuthor = new ArrayList<Library>();
		
		List<Library> books= repository.findAll();
		
		for(Library item: books)
		{
			if(item.getAuthor().equalsIgnoreCase(authorName))
			{
				bookswithAuthor.add(item);
			}
		}
		return bookswithAuthor;
			
		}
		
		
	
		
	}


