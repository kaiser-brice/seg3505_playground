import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    FizzBuzz fizzBuzz = new FizzBuzz();
    @Test
    public void checkDivisibilityBy3() {
        Assertions.assertEquals("Fizz", fizzBuzz.process(9));
        Assertions.assertEquals("Fizz", fizzBuzz.process(12));
    }


}