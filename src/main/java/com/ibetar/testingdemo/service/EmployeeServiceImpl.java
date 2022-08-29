package com.ibetar.testingdemo.service;

import com.ibetar.testingdemo.exceptions.EmployeeAppExceptions;
import com.ibetar.testingdemo.presistence.entity.Employee;
import com.ibetar.testingdemo.presistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() throws Exception {
        try {
            List<Employee> employees = employeeRepository.findAll();
            return employees;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee findById(Long id) throws Exception {
        Optional<Employee> optionalE =this.employeeRepository.findById(id);
        if(!optionalE.isEmpty()){
            try {
                Optional<Employee> entityOptional = employeeRepository.findById(id);
                return entityOptional.get();
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        throw new EmployeeAppExceptions("ID que usted busca no existe en la Base de Datos", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) throws Exception {
        try {
            employee = employeeRepository.save(employee);
            return employee;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Employee update(Long id, Employee entity) throws Exception {

        try {
            Optional<Employee> entityOptional = employeeRepository.findById(id);
            Employee entityUpdate = entityOptional.get();
            entityUpdate = employeeRepository.save(entity);
            return entityUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (employeeRepository.existsById(id)){
                employeeRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID No existe");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
