package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee checkEmployee(String firstName, String lastName);

    Map<Employee,Integer> getAll();
}
