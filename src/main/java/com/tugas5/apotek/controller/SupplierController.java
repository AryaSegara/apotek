package com.tugas5.apotek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tugas5.apotek.model.Supplier;
import com.tugas5.apotek.service.SupplierService;

@Controller
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    // untuk menampilkan list supplier dari database
    @GetMapping("/list-supplier")
    public String list(Model model){
        List <Supplier> supplierList = supplierService.getAllSupplier();
        model.addAttribute("supplierList",supplierList);
        return "list-supplier";
    }


    // untuk menambahkan supplier yang baru (Ini Untuk HTML)
    @GetMapping("/add-supplier")
    public String addSupplier(Model model){
        Supplier supplier = new Supplier();
        model.addAttribute(supplier);
        return "add-supplier";
    }

    // untuk meng - save data yang di inputkan dan menyimpan ke database
    @PostMapping("/save-supplier")
    public String saveSupplier(@ModelAttribute("supplier")  Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/list-supplier"; // langsung ke html list-supplier
    }


    // untuk mengedit supplier berdasarkan id(Ini untuk HTML)
    @GetMapping("/update-supplier/{id}")
    public String updateSupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier",supplier);
        return "update-supplier";
    }


    //untuk menyimpan nya ke dalam database yg sudah di update
    @PostMapping("/update-supplier/{id}")
    public String updateSupplier(@PathVariable Integer id, @ModelAttribute("supplier") Supplier supplier){
        Supplier update = supplierService.findById(id);
        update.setName(supplier.getName());
        update.setAddress(supplier.getAddress());
        update.setPhone(supplier.getPhone());
        supplierService.save(update);
        return "redirect:/list-supplier"; // langsung ke html list-supplier setelah meng update
    }



    //untuk meng hapus / delete berdasarkan id
    @GetMapping("/delete-supplier/{id}")
    public String deleteSupplier(@PathVariable Integer id){
        supplierService.deleteById(id);
        return "redirect:/list-supplier";
    }


}

