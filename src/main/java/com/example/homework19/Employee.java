package com.example.homework19;

import java.util.Objects;


public class Employee {

    private String firstName;

    private String lastName;

    private Integer salary;
    private Integer departament;



    public Employee(String firstName, String lastName, Integer salary, Integer departament) {
    this.firstName = firstName;
    this.lastName = lastName;
        this.salary = salary;
        this.departament = departament;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "first name='" + firstName + "last name" + lastName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(departament, employee.departament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departament);
    }

    public Integer getDepartament() {
        return departament;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String fullName() {
        return firstName +" "+lastName;
    }
}

