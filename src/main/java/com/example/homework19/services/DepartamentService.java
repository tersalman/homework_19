package com.example.homework19.services;

import com.example.homework19.Employee;

import java.util.List;
import java.util.Map;

public interface DepartamentService {
    Integer getSalarySum(Integer departmentId);
    Employee employeeInDepartamentWithMaxSalary(Integer departament);

    Employee employeeInDepartamentWithMinSalary(Integer departament);

    List<Employee> getEmployees(Integer departament);

    Map<Integer, List<Employee>> getAllSortedByDepartament();
}
