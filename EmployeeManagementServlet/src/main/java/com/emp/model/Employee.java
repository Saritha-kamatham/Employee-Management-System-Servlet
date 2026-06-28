package com.emp.model;

public class Employee {

    private int emp_id;
    private String emp_name;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(int emp_id, String emp_name,
                    String department, double salary) {

        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}