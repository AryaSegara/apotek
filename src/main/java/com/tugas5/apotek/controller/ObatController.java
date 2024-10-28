package com.tugas5.apotek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tugas5.apotek.model.Obat;
import com.tugas5.apotek.service.ObatService;

@Controller
public class ObatController {
    
    @Autowired
    private ObatService obatService;

    // menampilkan halaman home dengan daftar obat
    @GetMapping("/home")
    public String homePage(Model model){
        List <Obat> obatList = obatService.getAllObat();
        model.addAttribute("obatList", obatList);
        return "home";
    }

    // menampilkan halaman form tambah obat
    @GetMapping("/add-obat")
    public String addObatPage(Model model){
        Obat obat = new Obat();
        model.addAttribute("obat", obat);
        return "add-obat";
    }

    // menambahkan data obat baru
    @PostMapping("/save-obat")
    public String addObat(@ModelAttribute ("obat") Obat obat){
        obatService.saveObat(obat);
        return "redirect:/home";
    }

    // menghapus obat berdasarkan ID
    @GetMapping("/delete-obat/{id}")
    public String deleteObat(@PathVariable Integer id){
        obatService.deleteObatById(id);
        return "redirect:/home";
    }

}
