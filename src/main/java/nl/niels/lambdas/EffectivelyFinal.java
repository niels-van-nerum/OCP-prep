package nl.niels.lambdas;

import java.util.function.Predicate;

/**
 * A value is effectively final if it is not declared final, but used as a final value.
 * Take X in this example, it's only assigned a value once in its declaration. We didn't put the final keyword before x,
 * even though in this context it could have been final. The compiler knows has seen this, and has made the variable x effectively final.
 * This is more efficient for the compiled code. However, it is important to know that lambda's take snapshots of values, meaning x can not
 * be changed when it is defined in a lambda, try uncommenting x++, immediatly you will see that get an error defined by Intellij.
 * </p>
 * Summary: values consumed in a lambda expression, need to be final or effectively final.
 */
public class EffectivelyFinal {
    String name;

    static void main() {
        int x = 10;
        // x++;

        Predicate<String> isMaximumBiggerThanX = str -> {
            String comparedName = new EffectivelyFinal().name = "Niels";
            return str.length() - comparedName.length() < x;
        };

        String name1 = "Jonathan";
        String name2 = "Linus";

        System.out.println(isMaximumBiggerThanX.test(name1));
        System.out.println(isMaximumBiggerThanX.test(name2));
    }
}
