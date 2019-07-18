package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcuratorateService {
    @Autowired
    private ProcuratorateRepository repository;

    public Optional<Procuratorate> findById(int id) {
        return repository.findById(id);
    }
}
