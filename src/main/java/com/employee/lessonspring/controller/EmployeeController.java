package com.employee.lessonspring.controller;

import com.employee.lessonspring.model.Employee;
import com.employee.lessonspring.record.EmployeeRequest;
import com.employee.lessonspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/* Методы .maping:
 * GET - получение ресурса
 * POST - осздание ресурса
 * PUT - модификация (изменение) ресурса
 * PATCH - частичная модификация ресурса
 * DELETE - удаление ресурса
 */
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    Collection<Employee> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }

    @PostMapping("/employee")
    Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    int getSalarySum() {
        return this.employeeService.getSalarySum();
    }


}
