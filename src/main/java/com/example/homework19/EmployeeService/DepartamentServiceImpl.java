package com.example.homework19.EmployeeService;

import com.example.homework19.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    private final EmployeeService employeeService;

    public DepartamentServiceImpl(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }


    @Override
    public Employee employeeInDepartamentWithMaxSalary(Integer departament) {
        return employeeService.getAll().values().stream().filter(employee -> departament.equals(employee.getDepartament()))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }

    @Override
    public Employee employeeInDepartamentWithMinSalary(Integer departament) {
        return employeeService.getAll().values().stream().filter(employee -> departament.equals(employee.getDepartament()))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeeByDepartament(Integer departament) {
        return employeeService.getAll().values().stream().filter(employee -> departament.equals(employee.getDepartament()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllSortedByDepartament() {
        return employeeService.getAll().values().stream().collect(Collectors.groupingBy(Employee::getDepartament));
    }
}
