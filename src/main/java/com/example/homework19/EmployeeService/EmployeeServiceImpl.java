package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;
import com.example.homework19.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework19.Exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String,Employee> employeeMap = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName,  Integer salary, Integer departament) {

        Employee employee = new Employee(firstName, lastName, salary, departament);
        if (employeeMap.containsKey(employee.fullName())) {
            throw new EmployeeAlreadyAddedException("employee was added");
        }

        employeeMap.put(employee.fullName(),employee);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName,  Integer salary, Integer departament) {
        Employee employee = new Employee(firstName, lastName, salary, departament);
        if (!employeeMap.containsKey(employee.fullName())) {
        throw new EmployeeNotFoundException("this is employee not found");
        }
        employeeMap.remove(employee.fullName());
        return employee;
    }

    @Override
    public Employee checkEmployee(String firstName, String lastName, Integer salary, Integer departament) {
        Employee employee1 = new Employee(firstName, lastName, salary, departament);
        if (employeeMap.containsKey(employee1.fullName())) {
            return employee1;
        }
        throw new EmployeeNotFoundException("this is employee not found");

    }


    @Override
    public Map<String,Employee> getAll() {
        return new HashMap<>(employeeMap);
    }
}
