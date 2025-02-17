package net.joshuabrandes.primes.control;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PrimesHandler {

    private Random random = new Random();

    public long countPrimes(long maxValue) {
        var count = 0L;
        for (long i = 0; i < maxValue; i++) {
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(long number) {
        // modify the number by +- 100 to avoid JVM learning
        var n = number + random.nextInt(200) - 100;
        var sqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
