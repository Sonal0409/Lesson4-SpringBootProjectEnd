package com.Lesson4EndProject.com.Lesson4EndProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application  {

	/*@Autowired
	LibraryRepository repository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Override
	public void run(String args[]){
		
		// find and get data from columns based on the id 
		
		//Library lib = repository.findById("5Nov1").get();
		//System.out.println(lib.getBook_name());
		//System.out.println(lib.getAuthor());
		
		// Insert data in to the Table using set methods
		
		Library en = new Library();
		
		en.setBook_name("Appiumv6");
		en.setAuthor("Appium");
		en.setIsbn("abc");
		en.setAisle(203);
		en.setId("abc203");
		
		//repository.save(en);
		
		// to fetch all data from the table
		
		
	List<Library>allrecords = repository.findAll();
		
		for(Library item: allrecords)
		{
			System.out.println(item.getBook_name());
		}
		
		repository.delete(en);
		
		
	}*/

}
