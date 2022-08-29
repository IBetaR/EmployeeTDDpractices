package com.ibetar.testingdemo.controller;

import com.ibetar.testingdemo.exceptions.EmployeeAppExceptions;
import com.ibetar.testingdemo.presistence.entity.Employee;
import com.ibetar.testingdemo.presistence.repository.EmployeeRepository;
import com.ibetar.testingdemo.service.EmployeeService;
import com.sun.istack.NotNull;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody @NotNull Employee entity){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }

    @GetMapping
    public List<Employee> getAll() throws Exception {
        return employeeService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws EmployeeAppExceptions {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"NOT_FOUND\":\"Recurso no encontrado en la base de datos, revise la request.\"}");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable @NotNull Long id, @RequestBody Employee entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"BAD REQUEST\":\"Error Por favor revise la request.\"}");
        }
    }
}
