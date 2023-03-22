package org.example.java17.records;

import java.util.Objects;

public record MyRecord(String name, int age) {
/* non static fields not allowed in records
    private int field;
    */
    private static final String s1 = "";
    static final String s2 = "";
    protected static final String s3 = "";
    public static String s4 = "";

    public MyRecord() {
        this("", 0); // must be invoked
        System.out.println("empty record!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyRecord record)) return false;
        return age == record.age && Objects.equals(name, record.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "MyRecord{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //getters have another naming convention instead getFieldName()
    @Override
    public String name() {
        return name;
    }

    @Override
    public int age() {
        return age;
    }

}
