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

    @Test
    public void checkDivisibilityBy5() {
        Assertions.assertEquals("Buzz", fizzBuzz.process(125));
        Assertions.assertEquals("Buzz", fizzBuzz.process(25));
    }

    @Test
    public void checkDivisibilityBy3and5() {
        Assertions.assertEquals("FizzBuzz", fizzBuzz.process(15));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.process(30));
    }


}