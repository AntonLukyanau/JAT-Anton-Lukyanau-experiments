package org.example.practice.jat;

public class Accountant implements ICanBonusCalculate, ICanPayCalculate {

    @Override
    public Money calculateBonus(Employee e) {
        return e.calculateBonus();
    }

    @Override
    public Money calculatePay(Employee e) {
        return e.calculatePay();
    }

}
