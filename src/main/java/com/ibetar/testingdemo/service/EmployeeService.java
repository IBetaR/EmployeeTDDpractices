package com.ibetar.testingdemo.service;

import com.ibetar.testingdemo.presistence.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface EmployeeService extends Serializable {

    public List<Employee> findAll() throws Exception;
    public Employee findById(Long id) throws Exception;
    public Employee save(Employee entity) throws Exception;
    public Employee update(Long id, Employee entity) throws Exception;
    public boolean delete(Long id) throws  Exception;
}
