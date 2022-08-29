package com.ibetar.testingdemo.presistence.repository;

import com.ibetar.testingdemo.presistence.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    @DisplayName("Create and Save an employee in DB")
    public void saveEmployeeTest(){
        Employee employee = Employee.builder()
                .id(1L)
                .firstname("Ilich")
                .lastname("Betancourt Rangel")
                .address("Buyayiski 810, Las Grutas")
                .dni(95783711)
                .email("ilichbr@gmail.com")
                .build();
        employeeRepository.save(employee);

        assertAll(
                () -> Assertions.assertThat(employee.getId()).isGreaterThan(0),
                () -> assertEquals(employee.getFirstname(), "Ilich")


        );

    }

}