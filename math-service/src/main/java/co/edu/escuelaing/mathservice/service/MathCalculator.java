package co.edu.escuelaing.mathservice.service;

import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class MathCalculator {
    /**
     * Calcula la secuencia de Collatz para un número dado
     * Reglas:
     * - Si n es par: f(n) = n/2
     * - Si n es impar: f(n) = 3n + 1
     * La secuencia termina cuando llega a 1
     */
    public String collatzSequence(int value) {
        if (value <= 0) {
            return "Error: El número debe ser positivo";
        }
        
        StringBuilder sequence = new StringBuilder();
        long current = value;
        
        sequence.append(current);
        
        while (current != 1) {
            if (current % 2 == 0) {
                // Si es par: n/2
                current = current / 2;
            } else {
                // Si es impar: 3n + 1
                current = 3 * current + 1;
            }
            sequence.append(" -> ").append(current);
        }
        
        return sequence.toString();
    }
}
