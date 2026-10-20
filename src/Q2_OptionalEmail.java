import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Q2. Storing a student's email address in an Optional<String>.
 */
public class Q2_OptionalEmail {

    public static void main(String[] args) {
        System.out.println("=== Q2: Optional<String> Email ===");

        // 1. Create an Optional containing an email address
        Optional<String> email = Optional.of("student@university.edu");
        System.out.println("1. Optional with value created : " + email);

        // 2. Create an empty Optional
        Optional<String> emptyEmail = Optional.empty();
        System.out.println("2. Empty Optional created      : " + emptyEmail);

        // 3. Display the email using ifPresent()
        System.out.print("3. ifPresent() on email        : ");
        email.ifPresent(e -> System.out.println("Email = " + e));

        System.out.print("   ifPresent() on empty        : ");
        emptyEmail.ifPresent(e -> System.out.println("Email = " + e));
        System.out.println("(nothing printed - Optional is empty)");

        // 4. Use orElse() to provide a default email address
        String defaultEmail = "noemail@university.edu";
        System.out.println("4. orElse() with value         : " + email.orElse(defaultEmail));
        System.out.println("   orElse() with empty         : " + emptyEmail.orElse(defaultEmail));

        // 5. Use orElseThrow() to handle a missing email value
        try {
            System.out.println("5. orElseThrow() with value    : " + email.orElseThrow());
            // Throws NoSuchElementException because the Optional is empty
            String value = emptyEmail.orElseThrow();
            System.out.println(value);
        } catch (NoSuchElementException ex) {
            System.out.println("   orElseThrow() on empty      : Caught -> " + ex.getMessage());
        }

        // orElseThrow() with a custom exception supplier
        try {
            emptyEmail.orElseThrow(() -> new IllegalArgumentException("Student email is missing!"));
        } catch (IllegalArgumentException ex) {
            System.out.println("   orElseThrow(supplier)       : Caught -> " + ex.getMessage());
        }
    }
}
