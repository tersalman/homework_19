package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer salary, Integer departament);

    Employee deleteEmployee(String firstName, String lastName, Integer salary, Integer departament);

    Employee checkEmployee(String firstName, String lastName, Integer salary, Integer departament);



    Map<String, Employee> getAll();
}
