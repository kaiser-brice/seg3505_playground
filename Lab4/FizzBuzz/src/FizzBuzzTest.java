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

    @Test
    public void checkNonDivisibilityBy3or5() {
        Assertions.assertEquals("2", fizzBuzz.process(2));
        Assertions.assertEquals("7", fizzBuzz.process(7));
    }

    @Test
    public void checkResultEqualityForTwoIntegers() {
        Assertions.assertEquals(false, fizzBuzz.equal(2,3));
        Assertions.assertEquals(true, fizzBuzz.equal(2, 2));
        Assertions.assertEquals(true, fizzBuzz.equal(3, 9));
        Assertions.assertEquals(false, fizzBuzz.equal(15, 5));
        Assertions.assertEquals(false, fizzBuzz.equal(3, 5));
    }
}