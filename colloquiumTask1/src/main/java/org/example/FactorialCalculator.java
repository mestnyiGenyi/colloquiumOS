package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class FactorialCalculator {

    public List<BigInteger> calculateFactorials(int n) {
        validateInput(n);

        List<BigInteger> factorials = new ArrayList<>();
        if (n == 0) {
            return factorials;
        }

        factorials.add(BigInteger.ONE);
        for (int i = 2; i <= n; i++) {
            BigInteger previous = factorials.get(i - 2);
            BigInteger current = previous.multiply(BigInteger.valueOf(i));
            factorials.add(current);
        }

        return factorials;
    }

    public void validateInput(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative. Got: " + n);
        }
        
        if (n > 100000) {
            throw new IllegalArgumentException("n is too large for practical computation: " + n);
        }
    }
}
