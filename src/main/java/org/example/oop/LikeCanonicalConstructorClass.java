package org.example.oop;

//невозможно создать каноникал конструктор т.к. каноникал конструктор - это именно СГЕНЕРИРОВАННЫЙ конструктор в рекордах
//всё остальное не каноникал конструктор даже если совпадает по свойствам
public class LikeCanonicalConstructorClass {
    private final int id;
    private final String info;
    public LikeCanonicalConstructorClass(int id, String info) {
        this.id = id;
        this.info = info;
    }
    public LikeCanonicalConstructorClass(int id) {
        this(id,"default");
    }
    public LikeCanonicalConstructorClass(String info) {
        this(-1, info);
    }
    public LikeCanonicalConstructorClass() {
        this(-1, "default");
    }
}
