/**
 * @Author: Brice Joan Ngnawo SOh - nso087@uottawa.ca
 * ---------------------------------------------------
 * FizzBuzz is a program which takes an integer, n:
 * returns Fizz if n is divisble by 3
 * returns Buzz if n is divisible by 5
 * returns FIzzBuzz if n is divisible by 3 and 5
 * returns n is n is not divisible neither by 3 and 5
 */
public class FizzBuzz {
    public FizzBuzz() {
    }
    public String process(int n){
        if(n % 3 == 0 && n % 5 != 0){
            return "Fizz";
        }

        if(n % 5 == 0 && n % 3 != 0){
            return "Buzz";
        }

        if(n % 15 == 0){
            return "FizzBuzz";
        }

        return String.valueOf(n);
    }

    public boolean equal(int n, int m){
        return false;
    }
}
