package com.example.homework27;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/employee/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.addEmployee(firstName,lastName);
    }
    @GetMapping(path = "/employee/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.findEmployee(firstName,lastName);
    }
    @GetMapping(path = "/employee/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.removeEmployee(firstName,lastName);
    }
    @GetMapping(path = "/employee")
    public Collection<Employee> allEmployee(){
        return employeeService.addEmployee();
    }
}
