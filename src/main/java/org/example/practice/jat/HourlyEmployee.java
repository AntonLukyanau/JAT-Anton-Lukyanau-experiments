package org.example.practice.jat;

public class HourlyEmployee extends Employee {
    @Override
    public Money calculatePay() {
        return new Money(100000);
    }

    @Override
    public Money calculateBonus() {
        return new Money(10000);
    }
}
