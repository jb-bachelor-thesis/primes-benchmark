package net.joshuabrandes.primes.boundary;

import net.joshuabrandes.primes.control.PrimesHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RequestController {

    private final PrimesHandler primesHandler;

    public RequestController(PrimesHandler primesHandler) {
        this.primesHandler = primesHandler;
    }

    @GetMapping("/primes/{max-value}")
    public ResponseEntity<Long> getPrimes(@PathVariable("max-value") long maxValue) {
        return ResponseEntity.ok(primesHandler.countPrimes(maxValue));
    }
}
