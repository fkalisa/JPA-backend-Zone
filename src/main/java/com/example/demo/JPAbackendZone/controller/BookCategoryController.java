package com.example.demo.JPAbackendZone.controller;

import com.example.demo.JPAbackendZone.DAO.BookCategory;
import com.example.demo.JPAbackendZone.repository.BookCategoryRepository;
import com.example.demo.JPAbackendZone.request.BookCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookCategoryController {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @GetMapping("/getBookCategories")
    public List<BookCategory> getBookCategories() {
        return bookCategoryRepository.findAll();
    }

    @PostMapping("/insertBookCategory")
    public void insertBookCategory(@RequestBody BookCategoryRequest bookCategoryRequest) {
        BookCategory bookCategory = new BookCategory(bookCategoryRequest.getName());
        bookCategoryRepository.save(bookCategory);
    }

    @GetMapping("/getBookCategories/{name}")
    public List<BookCategory> getBookCategoryByName(@PathVariable String name) {
        return bookCategoryRepository.getBookCategoriesByName(name);
    }
}
