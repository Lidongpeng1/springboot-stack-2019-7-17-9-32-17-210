package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Prosecutor;
import com.tw.apistackbase.repository.ProsecutorRepository;
import com.tw.apistackbase.service.ProsecutorService;
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
class ProsectutorServiceTest {
    @Autowired
    private ProsecutorService service;

    @MockBean
    private ProsecutorRepository mockRepository;

    @Test
    void should_return_a_procurator_find_by_id_normally() {
        Prosecutor prosecutor = new Prosecutor();
        prosecutor.setId(1);
        prosecutor.setName("Hello");
        Optional<Prosecutor> prosecutorOptional = Optional.of(prosecutor);
        Mockito.when(mockRepository.findById(ArgumentMatchers.anyInt())).thenReturn(prosecutorOptional);

        Optional<Prosecutor> result = service.findById(prosecutor.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(prosecutor.getName(), result.get().getName());
    }
}
