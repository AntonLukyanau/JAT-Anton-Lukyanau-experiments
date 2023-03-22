package org.example.showsomething;

import org.example.StringUtil;
import org.example.model.Employee;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    private final Set<String> set = ((Supplier<Set<String>>) () -> {
        Set<String> strings = new HashSet<>();
        strings.add("xxx");
        return strings;
    }).get();


    public static void main(String[] args) {

//        String[] locales = Locale.getISOCountries();
//        for (String countryCode : locales) {
//            Locale obj = new Locale("", countryCode);
//            System.out.println("Country Code = " + obj.getCountry()
//                    + ", Country Name = " + obj.getDisplayCountry());
//        }

        List<Employee> employees = Stream.generate(() ->
                        new Employee(
                                StringUtil.generateString(),
                                StringUtil.generateString(),
                                (int) (Math.random() * 10000),
                                (int) (Math.random() * 100)))
                .limit(1_000)
                .toList();

        long start = System.currentTimeMillis();
        List<Employee> result = employees.parallelStream()
                .filter(employee -> employee.salary() > 1000)
                .sorted(Comparator.comparingInt(Employee::rating)
                        .thenComparingInt(Employee::salary))
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("parallel: " + (end - start));

        long start2 = System.currentTimeMillis();
        List<Employee> result2 = employees.stream()
                .filter(employee -> employee.salary() > 1000)
                .sorted(Comparator.comparingInt(Employee::rating)
                        .thenComparingInt(Employee::salary))
                .toList();
        long end2 = System.currentTimeMillis();
        System.out.println("sequential: " + (end2 - start2));
    }

}
