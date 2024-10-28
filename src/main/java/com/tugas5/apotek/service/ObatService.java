package com.tugas5.apotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.model.Obat;
import com.tugas5.apotek.repository.ObatRepository;

@Service
public class ObatService {
    @Autowired
    private ObatRepository obatRepository;

    // menampilkan semua data obat
    public List <Obat> getAllObat(){
        return obatRepository.findAll();
    }

    // menyimpan data obat baru
    public Obat saveObat (Obat obat){
        return obatRepository.save(obat);
    }

    // menghapus data obat berdasarkan id
    public void deleteObatById(Integer id){
        obatRepository.deleteById(id);
    }

    
    
}
