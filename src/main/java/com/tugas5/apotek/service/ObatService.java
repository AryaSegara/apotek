package com.tugas5.apotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.model.Category;
import com.tugas5.apotek.model.Obat;
import com.tugas5.apotek.model.Supplier;
import com.tugas5.apotek.repository.CategoryRepository;
import com.tugas5.apotek.repository.ObatRepository;
import com.tugas5.apotek.repository.SupplierRepository;

@Service
public class ObatService {
    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    // menampilkan semua data obat
    public List <Obat> getAllObat(){
        return obatRepository.findAll();
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public List<Supplier> getAllSupplier(){
        return  supplierRepository.findAll();

    }

    // menyimpan data obat baru
    public Obat saveObat (Obat obat){
        return obatRepository.save(obat);
    }

    // menghapus data obat berdasarkan id
    public void deleteObatById(Integer id){
        obatRepository.deleteById(id);
    }


    public Obat findById(Integer id){
        return obatRepository.findById(id).orElse(null);
    }

    
    
}
