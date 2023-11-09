package com.example.homework19.EmployeeController;

import com.example.homework19.Employee;
import com.example.homework19.EmployeeService.EmployeeService;
import com.example.homework19.EmployeeService.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/delete")
    public Employee delete(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping(path = "/check")
    public Employee check(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.checkEmployee(firstName, lastName);
    }

    @GetMapping
    public Map<Employee,Integer> getAll() {
        return employeeService.getAll();
    }

}
