package org.example.oop;

//каноникал конструктор ГЕНЕРИРУЕТСЯ только в рекордах
public record ExampleRecord(int id, String info) {

    public ExampleRecord(int id) {
        this(id,"default");
    }
    public ExampleRecord(String info) {
        this(-1, info);
    }
    public ExampleRecord() {
        this(-1, "default");
    }
}
