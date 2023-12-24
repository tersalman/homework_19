package com.example.homework19.services;

import com.example.homework19.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

public class DepartamentServiceImplTest {
@ExtendWith(MockitoExtension.class)
@Mock
   private EmployeeServiceImpl employeeService;

@InjectMocks
    private DepartamentServiceImpl departamentService;

    private final List<Employee> employees = new ArrayList<>(){{
        add(new Employee("ivan","Ivanova",1000,1));
        add(new Employee("ivan","Ivanovb",2000,1));
        add(new Employee("ivan","Ivanovc",3000,1));

        add(new Employee("ivan","Ivanovd",4000,2));
        add(new Employee("ivan","Ivanove",5000,2));

        add(new Employee("ivan","Ivanovf",6000,3));

    }};

    @Test
    public void shouldReturnEmployeeListSortedByDepatment() {
        int departmentId= 1;
        List<Employee> expectedEmployee = new ArrayList<>() {{
            add(employees.get(0));
            add(employees.get(1));
            add(employees.get(2));
        }};

        Map<String,Employee> employeeMap = new HashMap<>();
        for (Employee employee :employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }

        when(employeeService.getAll()).thenReturn(employeeMap);
        List<Employee> actualEmployees = departamentService.getEmployees(1);
        Assertions.assertEquals(expectedEmployee,actualEmployees);
    }

    @Test
    public void shouldCalculateSum(){
        int departmentId= 1;
        int expectedSum = 6000;

        Map<String,Employee> employeeMap = new HashMap<>();
        for (Employee employee :employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }


        when(employeeService.getAll()).thenReturn(employeeMap);
        Integer salarySum = departamentService.getSalarySum(departmentId);
        Assertions.assertEquals(expectedSum,salarySum);
    }
    @Test
    public void shouldFindMMinSalary(){
        int departmentId= 1;
        Employee expectedEmployee = employees.get(0);

        Map<String,Employee> employeeMap = new HashMap<>();
        for (Employee employee :employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }


        when(employeeService.getAll()).thenReturn(employeeMap);
        Employee employee = departamentService.employeeInDepartamentWithMinSalary(departmentId);
        Assertions.assertEquals(expectedEmployee,employee);
    }

    @Test
    public void shouldReturnNullWhenEmployeeISNOtAviable() {
        int departmentId= 1;

        when(employeeService.getAll()).thenReturn(Collections.emptyMap());

        Employee employee = departamentService.employeeInDepartamentWithMinSalary(departmentId);

        Assertions.assertNull(employee);
    }


    @Test
    public void shouldFindMaxSalary(){
        int departmentId= 1;
        Employee expectedEmployee = employees.get(2);

        Map<String,Employee> employeeMap = new HashMap<>();
        for (Employee employee :employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }


        when(employeeService.getAll()).thenReturn(employeeMap);
        Employee employee = departamentService.employeeInDepartamentWithMaxSalary(departmentId);
        Assertions.assertEquals(expectedEmployee,employee);
    }

    @Test
    public void shouldReturnMapWithEmployeesSortedByDepartment() {
        Map<String,Employee> employeeMap = new HashMap<>();
        for (Employee employee :employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);

        }
        when(employeeService.getAll()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> expectedMap = new HashMap<>(){{
            put(1,List.of(employees.get(2),employees.get(1),employees.get(0)));
            put(2,List.of(employees.get(3),employees.get(4)));
            put(3,List.of(employees.get(5)));

        }};

        Map<Integer, List<Employee>> actualMap;
        actualMap = departamentService.getAllSortedByDepartament();

        Assertions.assertEquals(expectedMap,actualMap);

    }



}
