package com.tugas5.apotek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.model.Obat;

public interface ObatRepository extends JpaRepository <Obat, Integer> {
    
}
