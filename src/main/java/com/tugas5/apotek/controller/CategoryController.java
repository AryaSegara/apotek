package com.tugas5.apotek.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tugas5.apotek.model.Category;
import com.tugas5.apotek.service.CategoryService;


@Controller
public class CategoryController{
    @Autowired
    private CategoryService categoryService;


    //untuk menampilkan semua category yg ada di database ke dalam bentuk html yg bernama list-category
    // (Ini Untuk HTML)
    @GetMapping("/list-category")
    public String list(Model model){
        List <Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "list-category";
    }


    // untuk menmbahkan category yang baru (Ini Untuk HTML)
    @GetMapping("/add-category")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute(category);
        return "add-category";
    }

    // untuk meng - save data yg diinputkan
    @PostMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/list-category"; // langsung ke list-category setelah meng save data baru
    }


    // untuk mengedit category berdasarkan id (Ini untuk ke HTML)
    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "update-category";
    }


    // untuk meng  save yg di edit 
    @PostMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Integer id, @ModelAttribute("category") Category category) {
        Category update = categoryService.findById(id);
        update.setName(category.getName());
        update.setDescription(category.getDescription());
        categoryService.save(category);
        return "redirect:/list-category"; // langsung ke list-category setelah update
    }



    // untuk meng hapus category berdasarkan id
    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/list-category"; // langsung ke list-category setlah delete
    }

}