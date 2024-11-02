package com.tugas5.apotek.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tugas5.apotek.model.Category;
import com.tugas5.apotek.service.CategoryService;


@Controller
public class CategoryController{
    @Autowired
    private CategoryService categoryService;


    //untuk menampilkan semua category yg ada di database ke dalam bentuk html yg bernama list-category
    @GetMapping("/list-category")
    public String list(Model model){
        List <Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "list-category";
    }


    // untuk menmbahkan category yang baru
    @GetMapping("/add-category")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute(category);
        return "add-category";
    }
    
}