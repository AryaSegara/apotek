package com.tugas5.apotek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.model.Supplier;

public interface SupplierRepository extends JpaRepository <Supplier, Integer> {
    
}
