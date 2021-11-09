package com.Lesson4EndProject.com.Lesson4EndProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lesson4EndProject.com.Lesson4EndProject.controller.Library;

public interface LibraryRepository extends JpaRepository<Library, String>,LibraryRepositoryCustom {

}
