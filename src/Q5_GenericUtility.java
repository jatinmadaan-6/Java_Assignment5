import java.util.Objects;
import java.util.Optional;

/**
 * Q5. Generic utility class with isEqual, getDefault, max, and isNull.
 */
public class Q5_GenericUtility {

    static class Utility {

        // 1. Checks whether two objects are equal (null-safe)
        public static <T> boolean isEqual(T a, T b) {
            return Objects.equals(a, b);
        }

        // 2. Returns the contained value or a default
        public static <T> T getDefault(Optional<T> value, T defaultValue) {
            return value.orElse(defaultValue);
        }

        // 3. Returns the larger of two comparable objects
        public static <T extends Comparable<T>> T max(T a, T b) {
            return a.compareTo(b) >= 0 ? a : b;
        }

        // 4. Checks whether an object is null using the Objects class
        public static boolean isNull(Object obj) {
            return Objects.isNull(obj);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Q5: Generic Utility Class ===");

        // isEqual
        System.out.println("\n-- isEqual --");
        System.out.println("isEqual(\"Java\", \"Java\")   : " + Utility.isEqual("Java", "Java"));
        System.out.println("isEqual(\"Java\", \"Python\") : " + Utility.isEqual("Java", "Python"));
        System.out.println("isEqual(100, 100)          : " + Utility.isEqual(100, 100));
        System.out.println("isEqual(3.14, 2.71)        : " + Utility.isEqual(3.14, 2.71));
        System.out.println("isEqual(null, null)        : " + Utility.isEqual(null, null));
        System.out.println("isEqual('A', 'a')          : " + Utility.isEqual('A', 'a'));

        // getDefault
        System.out.println("\n-- getDefault --");
        Optional<String> present = Optional.of("Amritsar");
        Optional<String> absent = Optional.empty();
        System.out.println("getDefault(present, \"Unknown\") : " + Utility.getDefault(present, "Unknown"));
        System.out.println("getDefault(absent, \"Unknown\")  : " + Utility.getDefault(absent, "Unknown"));
        System.out.println("getDefault(Optional.of(25), 0)  : " + Utility.getDefault(Optional.of(25), 0));
        System.out.println("getDefault(Optional.empty(), 0) : " + Utility.getDefault(Optional.<Integer>empty(), 0));

        // max
        System.out.println("\n-- max --");
        System.out.println("max(\"apple\", \"banana\") : " + Utility.max("apple", "banana"));
        System.out.println("max(45, 78)             : " + Utility.max(45, 78));
        System.out.println("max(9.5, 3.2)           : " + Utility.max(9.5, 3.2));
        System.out.println("max('x', 'c')           : " + Utility.max('x', 'c'));
        System.out.println("max(LocalDate)          : " + Utility.max(
                java.time.LocalDate.of(2026, 1, 1), java.time.LocalDate.of(2026, 12, 31)));

        // isNull
        System.out.println("\n-- isNull --");
        String nullStr = null;
        System.out.println("isNull(null)        : " + Utility.isNull(nullStr));
        System.out.println("isNull(\"Hello\")     : " + Utility.isNull("Hello"));
        System.out.println("isNull(123)         : " + Utility.isNull(123));
        System.out.println("isNull(new int[0])  : " + Utility.isNull(new int[0]));
    }
}
