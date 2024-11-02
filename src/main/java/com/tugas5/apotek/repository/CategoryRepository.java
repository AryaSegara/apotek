package com.tugas5.apotek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.model.Category;

public interface CategoryRepository extends JpaRepository <Category, Integer> {
    
}
