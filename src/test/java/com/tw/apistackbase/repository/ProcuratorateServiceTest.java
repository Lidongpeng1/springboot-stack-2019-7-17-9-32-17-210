package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import com.tw.apistackbase.service.ProcuratorateService;
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
class ProcuratorateServiceTest {
    @Autowired
    private ProcuratorateService service;

    @MockBean
    private ProcuratorateRepository mockRepository;

    @Test
    void should_return_a_procuratorate_find_by_id_normally() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setId(1);
        procuratorate.setName("Hello");
        Optional<Procuratorate> criminalCaseOptional = Optional.of(procuratorate);
        Mockito.when(mockRepository.findById(ArgumentMatchers.anyInt())).thenReturn(criminalCaseOptional);

        Optional<Procuratorate> result = service.findById(procuratorate.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(procuratorate.getName(), result.get().getName());
    }
}
