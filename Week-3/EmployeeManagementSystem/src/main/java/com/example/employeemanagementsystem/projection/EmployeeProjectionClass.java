package com.example.employeemanagementsystem.projection;

public class EmployeeProjectionClass {
    private String name;
    private String email;

    public EmployeeProjectionClass(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
