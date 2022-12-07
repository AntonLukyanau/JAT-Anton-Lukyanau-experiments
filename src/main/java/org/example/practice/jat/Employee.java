package org.example.practice.jat;

public abstract class Employee {

    private String name;
    private String type;

    public abstract Money calculatePay();

    public abstract Money calculateBonus();

}
