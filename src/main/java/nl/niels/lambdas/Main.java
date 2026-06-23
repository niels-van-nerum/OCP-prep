package nl.niels.lambdas;


import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        /*
        One of the lambdas that the default java API exposes is Predicate, it is a generic that
        allows for any object to be evaluated with .test(T t). And a set return of type boolean,
        meaning we can implement it as a means of asserting if something is true or not.
         */
        Predicate<Integer> isPositive = i -> i >= 0;
        System.out.println(isPositive.test(100));
        System.out.println(isPositive.test(-100));
        System.out.println(isPositive.test(0));

        String name = "Ms. Doe";
        System.out.println("Does " + name + "' name start with Mr.? " + check(name, s -> s.startsWith("Mr.")));

        /*
         * BiPredicate is used to assert something against something else, for example, is this city name a certain length?
         */
        String city = "Portugal";
        int length = 10;
        BiPredicate<String, Integer> isLength = (string, number) -> string.length() == number;
        System.out.println(isLength.test(city, length));

        /*
        A supplier can be used in many different ways, but is used when you want to declare something ahead of time,
        allowing the expensive call to be done, only when invoked.

        Factory Methods: Supplier can be used to create factory methods that generate new instances of objects.
        Lazy Initialization: Deferring the creation of an object until it is actually needed.
        Deferred Execution: Deferring execution of a piece of code until a result is required.
        Caching: Using a Supplier to provide cached results.
         */
        Supplier<String> greetingSupplier = () -> "Hello, World!";
        System.out.println(greetingSupplier.get());
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

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}


