package co.edu.escuelaing.mathservice.service;

import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class MathCalculator {

    /**
     * Calcula el n-ésimo número de Fibonacci
     */
    public String fibonacci(int n) {
        if (n < 0) {
            return "Error: El número debe ser no negativo";
        }
        if (n == 0) return "0";
        if (n == 1) return "1";
        
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        
        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        
        return b.toString();
    }

    /**
     * Calcula el factorial de n
     */
    public String factorial(int n) {
        if (n < 0) {
            return "Error: El número debe ser no negativo";
        }
        
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result.toString();
    }

    /**
     * Verifica si un número es primo
     */
    public String isPrime(int n) {
        if (n <= 1) {
            return "false";
        }
        if (n == 2) {
            return "true";
        }
        if (n % 2 == 0) {
            return "false";
        }
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return "false";
            }
        }
        
        return "true";
    }

    /**
     * Calcula la potencia de un número
     */
    public String power(int base, int exponent) {
        if (exponent < 0) {
            return "Error: El exponente debe ser no negativo";
        }
        
        BigInteger result = BigInteger.valueOf(base).pow(exponent);
        return result.toString();
    }

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
