package org.example.generics.model;

import java.util.Objects;

public class Phone extends Product<Phone> {
    private String model;
    private int memory;

    public Phone(String name, long price, String model, int memory) {
        super(name, price);
        this.model = model;
        this.memory = memory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
    @Override
    public String toString() {
        return "Phone{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", model='" + model + '\'' +
                "} ";
    }

    @Override
    public int compareTo(Phone phone) {
        int phoneModelDif = this.getModel().compareTo(phone.getModel());
        int phoneMemoryDif = this.getMemory() - phone.getMemory();
        if (phoneMemoryDif == 0 && phoneModelDif == 0) {
            return super.compareTo(phone);
        } if (phoneMemoryDif == 0){
            return phoneModelDif;
        }
        return phoneMemoryDif;
    }
}
