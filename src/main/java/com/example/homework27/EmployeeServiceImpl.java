package com.example.homework27;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee>employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
        if(employeeMap.containsKey(employee.firstAndLastName())){
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.firstAndLastName(), employee);
        return employee;
    }
    @Override
    public  Employee findEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
        if(employeeMap.containsKey(employee.firstAndLastName())){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
        if(employeeMap.containsKey(employee.firstAndLastName())){
            employeeMap.remove(employee.firstAndLastName(), employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> addEmployee() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
