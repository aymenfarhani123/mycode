import java.util.Optional;
import static java.lang.System.*;
public class OptionalExample {
    public static void main(String[] args) {
        Optional<Integer> canBeEmpty=Optional.of(5);
        int canBe=canBeEmpty.orElse(new Integer(5));
        int canBe2=canBeEmpty.orElseThrow(IllegalArgumentException::new);
        out.println(canBeEmpty.isPresent());
        out.println(canBeEmpty.get());

        Optional<Integer> emptyInt=Optional.empty();
        out.println(emptyInt.isPresent());
    }
}
