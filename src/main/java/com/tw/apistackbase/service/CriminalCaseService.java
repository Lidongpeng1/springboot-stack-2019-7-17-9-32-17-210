package com.tw.apistackbase.service;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseService {
    @Autowired
    private CriminalCaseRepository repository;

    public CriminalCase create(CriminalCase criminalCase) {
        return repository.save(criminalCase);
    }

    public Optional<CriminalCase> findById(int criminalCaseId) {
        return repository.findById(criminalCaseId);
    }

    public List<CriminalCase> findAllSortedByTime() {
        Sort sort = new Sort(Sort.Direction.DESC, "time");
        return repository.findAll(sort);
    }


}
