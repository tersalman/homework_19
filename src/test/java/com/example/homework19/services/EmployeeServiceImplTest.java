package com.example.homework19.services;

import com.example.homework19.Employee;
import com.example.homework19.Exceptions.EmployeeAlreadyAddedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {


    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

@Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenEmployeeAllredyExsisted(){

    Employee employee = new Employee("ivan","Ivanov",1000,1);
    employeeService.addEmployee(employee.getFirstName(), employee.getLastName(),
            employee.getSalary(), employee.getDepartament());

    Assertions.assertThrows(EmployeeAlreadyAddedException.class,()-> {
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getSalary(), employee.getDepartament());
    }
    );

    }
    @Test
    public void shouldCorrectlyFindEmployee(){

        Employee employee = new Employee("ivan","Ivanov",1000,1);
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getSalary(), employee.getDepartament());

        Employee actualEmployee = employeeService.checkEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartament());
        Assertions.assertEquals(employee,actualEmployee);
    }




















}
