package org.example.practice.jat;

public class CommissionedEmployee extends Employee {
    @Override
    public Money calculatePay() {
        return new Money(250000);
    }

    @Override
    public Money calculateBonus() {
        return new Money(25000);
    }

}
