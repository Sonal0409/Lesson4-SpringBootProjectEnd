package com.Lesson4EndProject.com.Lesson4EndProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Lesson4EndProject.com.Lesson4EndProject.repository.LibraryRepository;
import com.Lesson4EndProject.com.Lesson4EndProject.service.LibraryService;

@RestController
public class LibraryController {
	
	@Autowired
	LibraryRepository repository;
	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping("/addBook")
	public ResponseEntity addBookImplementation(@RequestBody Library library)
	{
		
		String id = libraryService.buildId(library.getIsbn(), library.getAisle());
		
		AddResponse ad = new AddResponse();
		
		if(!libraryService.checkBookAlreadyexist(id))
		{
		
		library.setId(id);
		repository.save(library);
		
		
		ad.setMsg("Book Added Successfully");
		ad.setId(id);
		
		return new ResponseEntity<AddResponse>(ad,HttpStatus.CREATED);
		}
		else
		{
			ad.setMsg("Book already Exists");
			ad.setId(id);
			
			return new ResponseEntity<AddResponse>(ad,HttpStatus.NOT_FOUND);
		}
		
	}
	
	// fetch books for an ID
	@GetMapping("/getBooks/{id}")
	public ResponseEntity<Library> getBookByid(@PathVariable(value="id")String id)
	{
		// 1. get the book by id
		
		try
		{
	Library	lib =repository.findById(id).get();
	
	
	//return lib;
	return new ResponseEntity<Library>(lib,HttpStatus.CREATED);
		}
		
		//2. give error message as Book not found if book is not existing
	
	catch(Exception e)
		{
	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	
		}
	
		
	}
	
	// fetch books by authorname
	
	@GetMapping("/getBooks/author")
	public List<Library> getBookbyAuthorName(@RequestParam(value="authorname")String authorname)
	{
		return repository.findAllByAuthor(authorname);
	}

	
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Library> updateBook(@PathVariable(value="id")String id,@RequestBody Library library)
	{
		Library existingBook  =repository.findById(id).get();
		existingBook.setAisle(library.getAisle());
		existingBook.setAuthor(library.getAuthor());
		existingBook.setBook_name(library.getBook_name());
		repository.save(existingBook);
		
		return new ResponseEntity<Library>(existingBook,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> deleteBook(@RequestBody Library library)
	{
		Library delBook = repository.findById(library.getId()).get();
		repository.delete(delBook);
		
		return new ResponseEntity<>("Book deleted successfully", HttpStatus.CREATED) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}













