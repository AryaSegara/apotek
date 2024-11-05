package com.tugas5.apotek.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Obat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String namaObat;
    private Long price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id" , referencedColumnName = "id")
    private Category category; //ini dari category_id

    @ManyToOne
    @JoinColumn(name = "supplier_id" , referencedColumnName = "id")
    private Supplier supplier; // ini dari supplier_id
}
