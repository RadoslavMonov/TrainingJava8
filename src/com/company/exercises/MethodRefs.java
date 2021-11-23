package com.company.exercises;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.*;

public class MethodRefs {

    public static void main(String[] args) {
        // Bound instance method reference (bound to the 's' String instance)
        String s = "rado";
        Supplier<String> methodRef = s::toUpperCase;
        System.out.println(methodRef.get());

        // normal way
        Consumer<String> greeterFn = greeting -> System.out.println(greeting);

        //method ref way
        Consumer<String> greeterFn2 = System.out::println;
        greeterFn2.accept("Hello from a bound instance method reference ");

        //Unbound instance method reference (
        BiConsumer<PrintStream, String> greeterFn3 = PrintStream::println;
        //since it's unbound we need to give it instances : System.out for PrintStream and the String literal
        greeterFn3.accept(System.out,"I'm an unbound instance method reference");

        //Static method reference (currentThread method is static)
        // currentThread method returns a thread value, so the FI we need is Supplier
        Supplier<Thread> threadFn = Thread::currentThread;
        System.out.println("Current thread is: " + threadFn.get());

        // Constructor method reference

        Supplier<Calendar> constrFn = GregorianCalendar::new;
        Calendar cal = constrFn.get();
        System.out.println("Calendar : " + cal);

        // Additional examples with lambda->method ref conversion

        // Static method ref

        Function<String, Double> doubleConverterLamdba = (str) -> Double.parseDouble(str);
        Function<String, Double> doubleConverterMethodRef = Double::parseDouble;

        System.out.println("result from lambda : " + doubleConverterLamdba.apply("3.522"));
        System.out.println("result from method ref: " + doubleConverterMethodRef.apply("3.522"));

        // Unbound instance method ref
        Consumer<String> lambdaStringPrinter = (str2) -> System.out.println(str2);
        Consumer<String> methodRefStringPrinter = System.out::println;

        lambdaStringPrinter.accept("lambda print");
        methodRefStringPrinter.accept("unbound method ref print");

        // Bound instance method ref
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        BiPredicate<List<Integer>, Integer> lamdbaIsPartOf = (list,num) -> list.contains(num);
        BiPredicate<List<Integer>, Integer> methodRefIsPartOf = List::contains;

        System.out.println("result from lamdba : " + lamdbaIsPartOf.test(intList, 6));
        System.out.println("result from method ref : " + methodRefIsPartOf.test(intList, 6));
    }
}
