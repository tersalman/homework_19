package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;
import com.example.homework19.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework19.Exceptions.EmployeeNotFoundException;
import com.example.homework19.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private static final int MAX_COUNT_OF_EMPLOYEE = 5;


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeeList.size() >= MAX_COUNT_OF_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("storege is full");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("employee was added");
        }

        employeeList.add(employee);
        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
        throw new EmployeeNotFoundException("this is employee not found");
        }
        employeeList.remove(employee);
        return employee;
    }

    @Override
    public Employee checkEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        for (Employee employee : employeeList) {
            if (employee.equals(employee1)) {
                return employee1;
            }
        }
        throw new EmployeeNotFoundException("this is employee not found");

    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employeeList);
    }
}
