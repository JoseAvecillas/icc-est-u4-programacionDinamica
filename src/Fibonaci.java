import java.util.*;

public class Fibonaci {
    
    // complejidad O(2 elevado a la n) - Exponencial
    public long fibonacci(long n){
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Compeljidad: O(n), espacion O(n) - Lineal
    private Map<Integer, Long> memo = new HashMap<>();

    public long fibonacciTD(int n){
        if (n <= 1) 
            return n;
        if (memo.containsKey(n)) 
            return memo.get(n);
        long resultado = fibonacciTD(n - 1) + fibonacciTD(n - 2);
        memo.put(n, resultado);
        return resultado;
    }

    public long fibonacciBU(int n){
        if (n <= 1) 
            return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];     
    }

    public int fibOptimizado(int n) {
        if (n <= 1) 
            return n;

        int prev2 = 0; 
        int prev1 = 1; 
        int actual = 0;

        for (int i = 2; i <= n; i++) {
            actual = prev1 + prev2; 
            prev2 = prev1;
            prev1 = actual;
        }

        return actual;
    }
}
