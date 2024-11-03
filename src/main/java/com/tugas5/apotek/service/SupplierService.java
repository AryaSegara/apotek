package com.tugas5.apotek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.model.Supplier;
import com.tugas5.apotek.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public void save(Supplier supplier){
        supplierRepository.save(supplier);
    }
}
