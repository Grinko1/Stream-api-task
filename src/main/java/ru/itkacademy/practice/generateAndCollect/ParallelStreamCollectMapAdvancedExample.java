package ru.itkacademy.practice.generateAndCollect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 35)),
                new Student("Student5", Map.of("Math", 77, "Chemistry", 85)),
                new Student("Student6", Map.of("Math", 55, "Physics", 58)),
                new Student("Student7", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student8", Map.of("Physics", 78, "Chemistry", 85)),
                new Student("Student9", Map.of("Math", 38, "Chemistry", 92)),
                new Student("Student10", Map.of("Physics", 78, "Chemistry", 85))
        );
        Map<String, Double> averageGrades = students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ));
        System.out.println(averageGrades);
    }
}
