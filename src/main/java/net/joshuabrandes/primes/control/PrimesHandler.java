package net.joshuabrandes.primes.control;

import org.springframework.stereotype.Component;

@Component
public class PrimesHandler {

    public long countPrimes(long maxValue) {
        var count = 0L;
        for (long i = 0; i < maxValue; i++) {
            if (isPrime(i)) count++;
        }

        return count;
    }

    private boolean isPrime(long n) {
        var sqrt = (long) Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
