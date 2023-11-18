package com.kyy.java.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");


        list.stream()
                .filter(s -> s.length() > 5) // condition (조건문)
                .map(String::toUpperCase) // 메소드레퍼런스
                .sorted().forEach(System.out::println); // 메소드레퍼런스

        list.stream()
                .filter(s -> s.length() > 6)
                .map(String::toLowerCase)
                .toList();

        String collect = list.stream().collect(Collectors.joining(", "));

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        double average = integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println(average);
        integers.stream().filter(i -> i % 2 == 0).reduce(Integer::sum).ifPresent(System.out::println);
        integers.stream().filter(i -> i % 3 == 0).reduce(Integer::sum).ifPresent(System.out::println);

        Map<Integer, List<Integer>> groupedByEvenOdd;
        groupedByEvenOdd = integers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? 0 : 1));

        System.out.println(groupedByEvenOdd);


    }
}
