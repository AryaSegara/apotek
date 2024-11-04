package com.tugas5.apotek.service;

import java.util.List;

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

    public void deleteById(Integer id){
        supplierRepository.deleteById(id);
    }

    public  Supplier findById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

    public List <Supplier>  getAllSupplier(){
        return supplierRepository.findAll();
    }

}
