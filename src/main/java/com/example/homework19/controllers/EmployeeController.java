package com.example.homework19.controllers;

import com.example.homework19.Employee;
import com.example.homework19.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") Integer salary, @RequestParam("departament") Integer departament) {

        return employeeService.addEmployee(firstName, lastName, salary, departament);
    }

    @GetMapping(path = "/delete")
    public Employee delete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") Integer salary, @RequestParam("departament") Integer departament) {
        return employeeService.deleteEmployee(firstName, lastName, salary, departament);
    }

    @GetMapping(path = "/check")
    public Employee check(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("salary") Integer salary, @RequestParam("departament") Integer departament) {
        return employeeService.checkEmployee(firstName, lastName, salary, departament);
    }

    @GetMapping
    public Map<String, Employee> getAll() {
        return employeeService.getAll();
    }

}
