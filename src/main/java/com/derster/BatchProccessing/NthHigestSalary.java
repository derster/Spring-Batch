package com.derster.BatchProccessing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthHigestSalary {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("anil", 1300);
        map.put("bhavna", 1300);
        map.put("micael", 1500);
        map.put("tom", 1600);
        map.put("ankit", 1200);
        map.put("daniel", 1700);
        map.put("james", 1400);

        Map<String, Integer> mapSalary = new HashMap<>();
        mapSalary.put("anil", 1700);
        mapSalary.put("bhavna", 1300);
        mapSalary.put("micael", 1300);
        mapSalary.put("tom", 1200);
        mapSalary.put("ankit", 1200);
        mapSalary.put("daniel", 1700);
        mapSalary.put("james", 1700);

        Map.Entry<String, Integer> nthHighestSalary = getNthHighestSalary(1, map);

        System.out.println(nthHighestSalary);


        Map<Integer, List<String>> collect = mapSalary.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
                ;
        System.out.println(collect);


        Map.Entry<Integer, List<String>> salaryResult = mapSalary.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(1);
        System.out.println(salaryResult);
    }

    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map){
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .toList()
                .get(num-1);
    }
}
