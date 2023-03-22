package org.example.java17.records;

public class RecordsMain {
    public static void main(String[] args) {
        MyRecord record = new MyRecord("Name", 18);
        MyRecord record2 = new MyRecord("Name", 18);
        MyRecord record3 = new MyRecord("Name3", 33);

        System.out.println(record2.hashCode());
        System.out.println(record3.hashCode());
        System.out.println(record2.equals(record));
        System.out.println(record2);
    }
}
