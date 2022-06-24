package com.alkemy.ong.controller;

import com.alkemy.ong.models.response.CategoryNameResponse;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.alkemy.ong.controller.ApiConstants.ROLE_ADMIN;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize(ROLE_ADMIN)
    @GetMapping
    public ResponseEntity<List<CategoryNameResponse>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }
}
