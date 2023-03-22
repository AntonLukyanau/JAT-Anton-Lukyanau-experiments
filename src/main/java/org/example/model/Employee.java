package org.example.model;

import java.util.Objects;

public final class Employee {
    private final String name;
    private final String department;
    private final int salary;
    private final int rating;

    public Employee(String name, String department, int salary, int rating) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.rating = rating;
    }

    public String name() {
        return name;
    }

    public String department() {
        return department;
    }

    public int salary() {
        return salary;
    }

    public int rating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Employee) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.department, that.department) &&
                this.salary == that.salary &&
                this.rating == that.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, rating);
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name=" + name + ", " +
                "department=" + department + ", " +
                "salary=" + salary + ", " +
                "rating=" + rating + ']';
    }

}