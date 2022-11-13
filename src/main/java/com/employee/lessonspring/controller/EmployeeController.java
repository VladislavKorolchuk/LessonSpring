package com.employee.lessonspring.controller;

import com.employee.lessonspring.model.Employee;
import com.employee.lessonspring.record.EmployeeRequest;
import com.employee.lessonspring.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

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

    @GetMapping("/employee/salary/sum") /* Получение суммы зарплат сотрудников */
    int getSalarySum() {
        return this.employeeService.getSalarySum();
    }
    @GetMapping("/employee/salary/min") /* Получение минимальной зарплаты сотрудника */
    OptionalInt getSalaryMin() {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("/employee/salary/max") /* Получение максимальной зарплаты сотрудника */
    OptionalInt getSalaryMax() {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("/employee/salary/aboveaverage")  /* Получение сотрудников с зарплатой выше средней */
    Set<Employee> getEmployeeSalaryHigherAverage() {
        return this.employeeService.getEmployeeSalaryHigherAverage();
    }

}
