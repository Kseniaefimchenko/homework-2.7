package com.example.homework27;
import java.util.Collection;
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);

    Collection<Employee> addEmployee();
}
