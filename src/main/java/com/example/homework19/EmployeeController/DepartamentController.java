package com.example.homework19.EmployeeController;

import com.example.homework19.Employee;
import com.example.homework19.EmployeeService.DepartamentService;
import com.example.homework19.EmployeeService.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "departament")
public class DepartamentController {

    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService=departamentService;
    }
    @GetMapping(path="/max-salary")
    Employee employeeInDepartamentWithMaxSalary(@RequestParam("departament") Integer departament) {
    return departamentService.employeeInDepartamentWithMaxSalary(departament);
    }
    @GetMapping(path="/min-salary")
    Employee employeeInDepartamentWithMinSalary(@RequestParam("departament") Integer departament) {
        return departamentService.employeeInDepartamentWithMinSalary(departament);
    }
    @GetMapping(path="/all")
    List<Employee> getAllEmployeeByDepartament(@RequestParam("departament") Integer departament) {
        return departamentService.getAllEmployeeByDepartament(departament);
    }
    @GetMapping(path="/all")
    Map<Integer, List<Employee>> getAllSortedByDepartament() {
        return departamentService.getAllSortedByDepartament();
    }

}
