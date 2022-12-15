package org.example.serializable;

public enum SingletonEnum {
    INSTANCE(1);

    int value;

    SingletonEnum(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return INSTANCE.name() + " with value " + value;
    }

}
