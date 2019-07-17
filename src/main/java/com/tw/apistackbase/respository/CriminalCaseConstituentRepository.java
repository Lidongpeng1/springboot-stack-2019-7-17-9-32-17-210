package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCaseConstituent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalCaseConstituentRepository extends JpaRepository<CriminalCaseConstituent, Integer> {
}
