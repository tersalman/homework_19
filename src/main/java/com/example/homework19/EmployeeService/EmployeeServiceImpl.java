package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;
import com.example.homework19.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework19.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Employee,Integer> employeeMap = new HashMap<>();
    private static  int employeeOrder = 0;




    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("employee was added");
        }

        employeeMap.put(employee,++employeeOrder);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeMap.containsKey(employee)) {
        throw new EmployeeNotFoundException("this is employee not found");
        }
        employeeMap.remove(employee);
        return employee;
    }

    @Override
    public Employee checkEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee1)) {
            return employee1;
        }
        throw new EmployeeNotFoundException("this is employee not found");

    }

    @Override
    public Map<Employee,Integer> getAll() {
        return new HashMap<>(employeeMap);
    }
}
