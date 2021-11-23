package com.company.exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsDemo {

    static class StudentExamResult {
        int roundedPercentage;
        String name;
        Exam exam;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentExamResult that = (StudentExamResult) o;
            return roundedPercentage == that.roundedPercentage && Objects.equals(name, that.name) && Objects.equals(exam, that.exam);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roundedPercentage, name, exam);
        }

        public StudentExamResult(int roundedPercentage, String name, Exam exam) {
            this.roundedPercentage = roundedPercentage;
            this.name = name;
            this.exam = exam;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "StudentExamResult{" +
                    "roundedPercentage=" + roundedPercentage +
                    ", name='" + name + '\'' +
                    ", exam=" + exam +
                    '}';
        }
    }

    static class Exam {
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Exam exam = (Exam) o;
            return Objects.equals(name, exam.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Exam(String name) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        List<StudentExamResult> results = getStudentResults();
        System.out.println(results);

        Set<String> topStudents = results.stream()
                .filter(result -> result.roundedPercentage >= 50)
                .map(StudentExamResult::getName)
                .collect(Collectors.toSet());

        List<String> alphabeticallySortedTopStudents = results.stream()
                .filter(result -> result.roundedPercentage > 50)
                .map(StudentExamResult::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Top students are: ");
        topStudents.forEach(System.out::println);

        System.out.println("Top students are (alphabetically sorted now) : ");
        alphabeticallySortedTopStudents.forEach(System.out::println);

    }

    private static List<StudentExamResult> getStudentResults() {
        Exam javaCertification = new Exam("Java Certification");
        Exam maven = new Exam("Maven");
        Exam apache = new Exam("Apache");


        List<StudentExamResult> results = new LinkedList<>();
        results.add(new StudentExamResult(56,"Sasho",maven));
        results.add(new StudentExamResult(72,"Pesho", javaCertification));
        results.add(new StudentExamResult(33,"Penka",maven));
        results.add(new StudentExamResult(55,"Menka", javaCertification));
        results.add(new StudentExamResult(14,"Dicho",apache));
        results.add(new StudentExamResult(33,"Misho", javaCertification));
        return  results;
    }
}
