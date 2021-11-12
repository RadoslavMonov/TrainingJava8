package com.company.exercises;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FIs {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
//        Supplier
        Supplier<Integer> supplier = () -> 42;
        System.out.println(supplier.get());

//        Function
        Function<Integer,String> function = age -> age > 21 ? "you can drink" : "sober";
        System.out.println(function.apply(17)); // sober

//      Consumer
        // lamdba way
        Consumer<String> greeterFn = greeting -> System.out.println(greeting);

        //method ref way
        Consumer<String> greeterFn2 = System.out::println;
        greeterFn2.accept("Hello from a method ref ");


        Predicate<Person> isInFrontOfPhoneDirectory = person -> person.name.substring(0,1).toUpperCase().equals("A");
        System.out.println(isInFrontOfPhoneDirectory.test(new Person("Adam",25))); //true
        System.out.println(isInFrontOfPhoneDirectory.test(new Person("Zoe",25))); //false

        Predicate<Person> isRetired = person -> person.age >= 65;
        System.out.println("Is Adam retired? - " + isRetired.test(new Person("Adam",25))); //false
        System.out.println("Is Sashka retired? - " + isRetired.test(new Person("Sashka Vaseva", 72))); //true
    }
}
