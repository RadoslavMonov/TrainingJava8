package com.company.exercises;

public class Demo {
    @FunctionalInterface
    public interface StringRunnable {
        public abstract void run(String str);
    }

    //FI with the same function descriptor Runnable
    @FunctionalInterface
    public interface Executor {
        void execute();
    }

    public static void main(String[] args) {
// lambda with str param and no param parenthesis when defined

        StringRunnable fn2 = name -> System.out.println("hello" + name + "!");
        fn2.run("Rado");

        //        simple lambdas no param

        Runnable fn = () -> {
            String name = "Matt";
            System.out.println("hello" + name + "!");
        };
        fn.run();

        Executor fn_ = () -> {
            String name = "Matt";
            System.out.println("hello" + name + "!");
        };
        fn_.execute();

    }
}
