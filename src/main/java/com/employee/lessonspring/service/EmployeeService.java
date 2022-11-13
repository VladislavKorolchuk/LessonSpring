package com.employee.lessonspring.service;

import com.employee.lessonspring.model.Employee;
import com.employee.lessonspring.record.EmployeeRequest;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public Collection<Employee> getAllEmployee() {
        return this.employeeMap.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartament(),
                employeeRequest.getSalary()
        );
        this.employeeMap.put(employee.getId(),employee);
        return employee;
    }

    public int getSalarySum() {
        return employeeMap.values().stream().mapToInt(t->t.getSalary()).sum();
    }
}
