package org.example.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 Задача: Напишите свой коллектор для преобразования элементов стрима в массив Integer
 */
public class ToArrayCollector implements Collector<Integer, Collection<Integer>, Integer[]> {

    @Override
    public Supplier<Collection<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<Collection<Integer>, Integer> accumulator() {
        return Collection::add;
    }

    @Override
    public BinaryOperator<Collection<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<Collection<Integer>, Integer[]> finisher() {
        return innerCollection -> Arrays.copyOfRange(
                innerCollection.toArray(),
                0, innerCollection.size(),
                Integer[].class);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
