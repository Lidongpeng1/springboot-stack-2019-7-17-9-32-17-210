package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCaseConstituent;
import com.tw.apistackbase.repository.CriminalCaseConstituentRepository;
import com.tw.apistackbase.service.CriminalCaseConstituentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CriminalCaseConstituentSeriviceTest {
    @Autowired
    private CriminalCaseConstituentService service;

    @MockBean
    private CriminalCaseConstituentRepository mockRepository;

    @Test
    void should_return_a_criminal_case_constituent_find_by_id_normally() {
        CriminalCaseConstituent constituent = new CriminalCaseConstituent();
        constituent.setId(1);
        constituent.setSubjectiveDescription("Hello");
        constituent.setObjectiveDescription("World");
        Optional<CriminalCaseConstituent> constituentOptional = Optional.of(constituent);
        Mockito.when(mockRepository.findById(ArgumentMatchers.anyInt())).thenReturn(constituentOptional);

        Optional<CriminalCaseConstituent> result = service.findById(constituent.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(1, result.get().getId());
        Assertions.assertEquals(constituent.getObjectiveDescription(), result.get().getObjectiveDescription());
        Assertions.assertEquals(constituent.getSubjectiveDescription(), result.get().getSubjectiveDescription());
    }
}