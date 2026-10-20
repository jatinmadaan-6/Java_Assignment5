/**
 * Q1. Generic method to calculate the sum of an array of numeric values.
 * Uses a bounded type parameter (T extends Number) and doubleValue().
 */
public class Q1_GenericSum {


    public static <T extends Number> double sum(T[] array) {
        double total = 0.0;
        for (T element : array) {
            total += element.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30, 40, 50};
        Float[] floatArray = {1.5f, 2.5f, 3.5f, 4.5f};
        Double[] doubleArray = {10.25, 20.75, 30.5, 40.5};

        System.out.println("=== Q1: Generic Sum of Numeric Arrays ===");
        System.out.println("Integer array sum : " + sum(intArray));
        System.out.println("Float array sum   : " + sum(floatArray));
        System.out.println("Double array sum  : " + sum(doubleArray));
    }
}
