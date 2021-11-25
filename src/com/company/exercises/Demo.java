package com.company.exercises;

public class Demo {

    @FunctionalInterface
    public interface StringRunnable {
        void run(String str);
    }

    // FI with the same function descriptor Runnable
    @FunctionalInterface
    public interface Executor {
        void execute();
    }

    public static void main(String[] args) {
        // lambda with str param and no param parenthesis when defined

        StringRunnable stringRunnableGreeterFn = name -> System.out.println("hello" + name + "!");
        stringRunnableGreeterFn.run("Rado");

        // simple lambdas no param

        Runnable runnableGreeterFn = () -> {
            String name = "Matt";
            System.out.println("hello" + name + "!");
        };
        runnableGreeterFn.run();

        Executor executor = () -> {
            String name = "Matt";
            System.out.println("hello" + name + "!");
        };
        executor.execute();

    }
}
