package com.derster.BatchProccessing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetAndOther {
    public static void main(String[] args) {
        Set<String> names = new LinkedHashSet<>();

        names.add("Modeste");
        names.add("Paule");
        names.add("Marc");
        names.add("Max");
        names.add("Sarra");
        names.add("Mirabelle");

        LinkedList<String> namesLinkedList = new LinkedList<>();
        namesLinkedList.add("Modeste");
        namesLinkedList.add("Paule");
        namesLinkedList.add("Marc");
        namesLinkedList.add("Max");
        namesLinkedList.add("Sarra");
        namesLinkedList.add("Mirabelle");

        ArrayList<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("Modeste");
        namesArrayList.add("Paule");
        namesArrayList.add("Marc");
        namesArrayList.add("Max");
        namesArrayList.add("Sarra");
        namesArrayList.add("Mirabelle");

        System.out.println(namesLinkedList);
        System.out.println(namesArrayList);


        String input = "ilovejavatechie";

        String[] splitInput = input.split("");



        Map<String, List<String>> collect = Arrays.stream(splitInput).collect(Collectors.groupingBy(c -> c));

        System.out.println(collect);

        Map<String, Long> collect1 = Arrays.stream(splitInput).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect1);

        // Find all duplicate element from a given string
        List<String> list = Arrays.stream(splitInput).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);
        // Find unique element from a given string
        List<String> list2 = Arrays.stream(splitInput).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(list2);

        // Find first non repeat element
        String string = Arrays.stream(splitInput).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst()
                .get().getKey();

        System.out.println(string);

        // Find first repeat element
        String str = Arrays.stream(splitInput).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .findFirst()
                .get().getKey();

        System.out.println(str);

        int[] numbers = {5, 9, 11, 2, 8, 21, 1};

        Integer integer = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(integer);

        // Find the longest string from given array

        String[] strArray = {"java", "techie", "springboot", "microservices"};

        String longestString = Arrays.stream(strArray)
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();

        System.out.println(longestString);


        // Find element from array who start with one

        List<String> collect2 = Arrays.stream(numbers).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .toList();
        System.out.println(collect2);

        // String.join

        List<String> nos = Arrays.asList("1", "2", "3", "4");

        String join = String.join("-", nos);
        System.out.println(join);

        // Skip & limit exemple (2-9)
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);
    }
}
