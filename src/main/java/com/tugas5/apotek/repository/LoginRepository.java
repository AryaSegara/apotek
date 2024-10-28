package com.tugas5.apotek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.model.Login;

public interface LoginRepository extends JpaRepository <Login, Integer>{
    List <Login> findByUsernameAndPassword(String username,String password);
}
