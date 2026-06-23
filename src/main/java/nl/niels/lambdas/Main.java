package nl.niels.lambdas;


import java.lang.classfile.attribute.SourceDebugExtensionAttribute;

/**
 * This package holds information on what lambdas are, how they are set up, and what some of the popular lambdas are in the API
 * </p>
 * To understand lambdas, you need to understand what an interface is,
 * an interface is a contract on what a class can do, not how it does it.
 * </p>
 * A class can extend a single interface, or implement multiple.
 * Implementing an interface means you need to adhere to the contract, and override all it's methods.
 * For example: A cat IS an Animal, and is Moveable and Lovable.
 * </p>
 * As of Java 8, interfaces can have default and static methods, they are inheritable, and don't have to be overridden.
 * Interfaces are inherently abstract, meaning they can not be instantiated.
 */
public class Main {
    static void main() {
        Calculator lambda = (a, b) -> System.out.println(a + b);
        lambda.operate(11, 4);
    }

    /**
     * Variables declared in an interface are public, static and final by default, making them CONSTANT.
     * All methods of an interface are implicitly public.
     */
    public interface Cat {
        String ORDER = "Mammal";
        String FAMILY = "Feline";

        String meow();
    }

    /**
     * A functional interface declares one method, known as the SAM rule (Single Abstract Method).
     * They are the backbone of lambdas, which is an easier way of writing code. Because FI have a single method,
     * The compiler can infer what method needs to be used for the lambda.
     */
    @FunctionalInterface
    public interface Calculator {
        void operate(int a, int b);
    }
}


