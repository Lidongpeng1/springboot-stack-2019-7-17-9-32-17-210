package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProsecutorService {
    @Autowired
    private ProsecutorRepository repository;

    public Optional<Prosecutor> findById(int id) {
        return repository.findById(id);
    }
}
