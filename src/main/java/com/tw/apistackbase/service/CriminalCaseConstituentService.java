package com.tw.apistackbase.service;

import com.tw.apistackbase.model.CriminalCaseConstituent;
import com.tw.apistackbase.repository.CriminalCaseConstituentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriminalCaseConstituentService {
    @Autowired
    private CriminalCaseConstituentRepository repository;

    public Optional<CriminalCaseConstituent> findById(int id) {
        return repository.findById(id);
    }
}
