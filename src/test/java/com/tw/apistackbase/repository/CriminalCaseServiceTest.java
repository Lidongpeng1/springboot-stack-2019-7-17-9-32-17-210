package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import com.tw.apistackbase.service.CriminalCaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CriminalCaseServiceTest {
    @Autowired
    private CriminalCaseService criminalCaseService;

    @MockBean
    private CriminalCaseRepository mockRepository;

    @Test
    void should_create_a_criminal_case_normally() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setName("Hello");
        criminalCase.setTime(System.currentTimeMillis());
        Mockito.when(mockRepository.save(ArgumentMatchers.any())).thenReturn(criminalCase);

        CriminalCase result = criminalCaseService.create(criminalCase);

        Assertions.assertEquals(criminalCase.getName(), result.getName());
        Assertions.assertEquals(criminalCase.getTime(), result.getTime());
    }

    @Test
    void should_return_a_criminal_case_find_by_id_normally() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(1);
        criminalCase.setName("Hello");
        criminalCase.setTime(System.currentTimeMillis());
        Optional<CriminalCase> criminalCaseOptional = Optional.of(criminalCase);
        Mockito.when(mockRepository.findById(ArgumentMatchers.anyInt())).thenReturn(criminalCaseOptional);

        Optional<CriminalCase> result = criminalCaseService.findById(criminalCase.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(criminalCase.getName(), result.get().getName());
        Assertions.assertEquals(criminalCase.getTime(), result.get().getTime());
    }

    @Test
    void should_return_criminal_case_list_find_sorted_by_time_normally() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(1);
        criminalCase.setName("Hello");
        criminalCase.setTime(System.currentTimeMillis());
        List<CriminalCase> criminalCases = Collections.singletonList(criminalCase);
        Mockito.when(mockRepository.findAll((Sort) ArgumentMatchers.any())).thenReturn(criminalCases);

        List<CriminalCase> result = criminalCaseService.findAllSortedByTime();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(criminalCase.getName(), result.get(0).getName());
        Assertions.assertEquals(criminalCase.getTime(), result.get(0).getTime());
    }

    @Test
    void should_return_criminal_case_list_find_by_name_normally() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(1);
        criminalCase.setName("Hello");
        criminalCase.setTime(System.currentTimeMillis());
        List<CriminalCase> criminalCases = Collections.singletonList(criminalCase);
        Mockito.when(mockRepository.findAll(ArgumentMatchers.any(Example.class))).thenReturn(criminalCases);

        List<CriminalCase> result = criminalCaseService.findAllByName(criminalCase.getName());

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(criminalCase.getName(), result.get(0).getName());
        Assertions.assertEquals(criminalCase.getTime(), result.get(0).getTime());
    }

    @Test
    void should_delete_a_criminal_case_delete_by_id_normally() {
        int criminalCaseId = 1;
        Mockito.doNothing().when(mockRepository).deleteById(ArgumentMatchers.anyInt());

        criminalCaseService.deleteById(criminalCaseId);

        Mockito.verify(mockRepository).deleteById(criminalCaseId);
    }
}