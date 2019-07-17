package com.tw.apistackbase.respository;

import com.tw.apistackbase.entiey.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseResposity extends JpaRepository<Case,Integer> {

     Case findAllCaseById(int id);

}
