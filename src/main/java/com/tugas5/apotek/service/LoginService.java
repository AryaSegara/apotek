package com.tugas5.apotek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.model.Login;
import com.tugas5.apotek.repository.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository loginRepository;

    // meyinmpan data baru dari register
    public void save(Login login){
        loginRepository.save(login);
    }

    public Login findByUsernameAndPassword(String username, String password){
        List <Login> login = loginRepository.findByUsernameAndPassword(username, password);
        return login.stream().findFirst().orElse(null);
    }


}
