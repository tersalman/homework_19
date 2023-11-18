package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Employee employeeInDepartamentWithMaxSalary(Integer departament);

    Employee employeeInDepartamentWithMinSalary(Integer departament);

    List<Employee> getAllEmployeeByDepartament(Integer departament);

    Map<Integer, List<Employee>> getAllSortedByDepartament();
}
