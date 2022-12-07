package org.example.practice.jat;

public class SalariedEmployee extends Employee {
    @Override
    public Money calculatePay() {
        return new Money(200000);
    }

    @Override
    public Money calculateBonus() {
        return new Money(20000);
    }
}
