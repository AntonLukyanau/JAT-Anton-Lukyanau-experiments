package org.example.annotations;

@MyTypeAnnotation
public record MyRecord(@MyRecordAnnotation("some text") int arg, @MyParametrAnnotation(2) int arg2) {
}
