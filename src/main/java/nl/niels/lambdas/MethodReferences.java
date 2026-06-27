package nl.niels.lambdas;

import java.util.function.Predicate;

/**
 * Method references are shorthand versions of writing a lambda expression.
 * </p>
 * Sometimes you will see that when writing a basic lambda, it can be s
 */
public class MethodReferences {

    static void main() {
        boundMethodReference();
    }

    /**
     *
     */
    static void boundMethodReference() {
        String name = "Niels";

        Predicate<String> startsWith = name::startsWith;
        System.out.println(startsWith.test("N"));
    }
}
