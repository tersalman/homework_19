package com.example.homework19.controllers;

import com.example.homework19.Employee;
import com.example.homework19.services.DepartamentService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "departament")
public class DepartamentController {

    private final DepartamentService departamentService;


    public DepartamentController(DepartamentService departamentService) {
        this.departamentService=departamentService;
    }

    @GetMapping("{id}/employees")
    List<Employee> getEmployees(@PathVariable("id") Integer id) {
        return departamentService.getEmployees(id);
    }

    @GetMapping(path="{id}/salary/sum")
    Integer getSalarySum(@PathVariable("id") Integer id) {
        return departamentService.getSalarySum(id);
    }
    @GetMapping(path="{id}/salary/max")
    Integer employeeInDepartamentWithMaxSalary(@PathParam("id") Integer id) {
    return departamentService.employeeInDepartamentWithMaxSalary(id).getSalary();
    }
    @GetMapping(path="{id}/salary/min")
    Integer employeeInDepartamentWithMinSalary(@PathVariable("id") Integer id) {
        return departamentService.employeeInDepartamentWithMinSalary(id).getSalary();
    }

    @GetMapping(path="/employee")
    Map<Integer, List<Employee>> getAllSortedByDepartament() {
        return departamentService.getAllSortedByDepartament();
    }

}
