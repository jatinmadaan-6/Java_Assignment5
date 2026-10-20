import java.util.Objects;
import java.util.Optional;

/**
 * Q3. Generic class Result<T extends Number> to store a student's marks.
 */
public class Q3_Result {

    static class Result<T extends Number> {
        private final String studentName;
        private final T[] marks;          // may be null/empty -> marks not available
        private final double maxMarksPerSubject;

        public Result(String studentName, T[] marks, double maxMarksPerSubject) {
            // 5. Validate required inputs
            this.studentName = Objects.requireNonNull(studentName, "Student name must not be null");
            this.marks = marks; // marks are optional; handled via Optional below
            if (maxMarksPerSubject <= 0) {
                throw new IllegalArgumentException("Max marks must be positive");
            }
            this.maxMarksPerSubject = maxMarksPerSubject;
        }

        // 2. Total using doubleValue() numeric conversion
        public double getTotal() {
            Objects.requireNonNull(marks, "Marks are required to calculate total");
            double total = 0;
            for (T m : marks) {
                total += Objects.requireNonNull(m, "Individual mark must not be null").doubleValue();
            }
            return total;
        }

        // 2. Average marks
        public double getAverage() {
            Objects.requireNonNull(marks, "Marks are required to calculate average");
            return getTotal() / marks.length;
        }

        // 2. Percentage
        public double getPercentage() {
            return (getTotal() / (marks.length * maxMarksPerSubject)) * 100;
        }

        // 3. Pass/fail based on a specified percentage threshold
        public boolean hasPassed(double thresholdPercentage) {
            return getPercentage() >= thresholdPercentage;
        }

        // 4. Display result using Optional
        public void display(double thresholdPercentage) {
            Optional<T[]> optMarks = Optional.ofNullable(marks);
            System.out.println("Student : " + studentName);
            optMarks.filter(m -> m.length > 0).ifPresentOrElse(
                m -> {
                    System.out.println("Marks   : " + java.util.Arrays.toString(m));
                    System.out.printf("Total   : %.2f%n", getTotal());
                    System.out.printf("Average : %.2f%n", getAverage());
                    System.out.printf("Percent : %.2f%%%n", getPercentage());
                    System.out.println("Status  : " + (hasPassed(thresholdPercentage)
                            ? "PASS" : "FAIL") + " (threshold " + thresholdPercentage + "%)");
                },
                () -> System.out.println("Marks   : Not available")
            );
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Q3: Generic Result<T extends Number> ===");

        Integer[] intMarks = {78, 85, 90, 67, 72};
        Result<Integer> r1 = new Result<>("Aman", intMarks, 100);
        r1.display(40);

        System.out.println();
        Double[] doubleMarks = {35.5, 28.0, 40.5, 30.0};
        Result<Double> r2 = new Result<>("Simran", doubleMarks, 100);
        r2.display(40);

        System.out.println();
        Float[] floatMarks = {45.5f, 38.0f, 41.5f};
        Result<Float> r3 = new Result<>("Gurpreet", floatMarks, 50);
        r3.display(50);

        System.out.println();
        Result<Integer> r4 = new Result<>("Harman", null, 100);   // marks not available
        r4.display(40);

        // Objects.requireNonNull() validation demo
        System.out.println();
        try {
            new Result<Integer>(null, intMarks, 100);
        } catch (NullPointerException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
        try {
            r4.getAverage();
        } catch (NullPointerException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
    }
}
