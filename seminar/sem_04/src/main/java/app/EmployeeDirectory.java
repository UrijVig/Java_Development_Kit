package main.java.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDirectory {
    private final Set<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new HashSet<>();
    }

    public List<Employee> getEmployeeByExperience(int experience){
        return employees.stream().filter(employee -> employee.experience() == experience)
                .toList();
    }
    public Employee getEmployeeByPersonalNumber(int personalNumber){
        return employees.stream()
                .filter(employee -> employee.personalNumber() == personalNumber)
                .findFirst().orElse(null);
    }
    public List<String> getPhoneNumberByName(String name){
        return employees.stream().filter(employee -> employee.name().equals(name))
                .map(Employee::phoneNumber).toList();
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
