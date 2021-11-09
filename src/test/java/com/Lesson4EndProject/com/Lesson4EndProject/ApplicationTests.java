package com.Lesson4EndProject.com.Lesson4EndProject;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Lesson4EndProject.com.Lesson4EndProject.controller.Library;
import com.Lesson4EndProject.com.Lesson4EndProject.controller.LibraryController;
import com.Lesson4EndProject.com.Lesson4EndProject.repository.LibraryRepository;
import com.Lesson4EndProject.com.Lesson4EndProject.service.LibraryService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	LibraryController con;
	
	@MockBean
	LibraryRepository repository;
	
	@MockBean
	LibraryService libraryService;

	@Test
	void contextLoads() {
	}
	
	//@Test
	public void checkbuildIdlogic()
	{
		LibraryService lib = new LibraryService();
		String id = lib.buildId("Znov", 1);
		
		System.out.println(id); // cancatination it with OLD + isbn+aisle==> OLDnov1
		Assertions.assertEquals("OLDZnov1", id);
		
	}
	
	@Test
	public void AddBookControllerTest()
	
	{
		
		Library lib = buildLibrary();
		
	when(libraryService.buildId(lib.getIsbn(), lib.getAisle())).thenReturn(lib.getId());
	when(libraryService.checkBookAlreadyexist(lib.getId())).thenReturn(true);
	ResponseEntity response=	con.addBookImplementation(buildLibrary());
		System.out.println(response.getStatusCode());
		Assertions.assertEquals(response.getStatusCode(),HttpStatus.ACCEPTED);
		
	}
	
	
	public Library buildLibrary()
	{
		Library lib = new Library();
		
		lib.setAisle(322);
		lib.setBook_name("SpringBoot1");
		lib.setIsbn("fes");
		lib.setAuthor("Jordan");
		lib.setId("fes322");
		return lib;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
