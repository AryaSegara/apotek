package com.tugas5.apotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.model.Category;
import com.tugas5.apotek.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }

    public List <Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }


}