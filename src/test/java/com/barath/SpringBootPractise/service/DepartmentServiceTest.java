package com.barath.SpringBootPractise.service;
import com.barath.SpringBootPractise.entity.Department;
import com.barath.SpringBootPractise.repository.DepartmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Ahmedabad")
                        .departmentCode("IT-06")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}