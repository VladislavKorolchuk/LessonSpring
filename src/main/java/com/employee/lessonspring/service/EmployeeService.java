package com.employee.lessonspring.service;

import com.employee.lessonspring.model.Employee;
import com.employee.lessonspring.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public int getSalarySum() { /* Получение суммы зарплат сотрудников */
        return employeeMap.values().stream().mapToInt(t->t.getSalary()).sum();
    }

    public OptionalInt getSalaryMin() { /* Получение минимальной зарплаты сотрудника */
        return employeeMap.values().stream().mapToInt(t->t.getSalary()).min();
    }

    public OptionalInt getSalaryMax() { /* Получение минимальной зарплаты сотрудника */
        return employeeMap.values().stream().mapToInt(t->t.getSalary()).max();
    }

    public int getSalaryAverage() { /* Получение средней зарплаты сотрудника */
        return getSalarySum() / employeeMap.size();
    }

    public Set<Employee> getEmployeeSalaryHigherAverage() { /* Получение сотрудников с зарплатой выше средней */
        return employeeMap.values().stream().filter(e->e.getSalary()>getSalaryAverage()).collect(Collectors.toSet());
    }

}
