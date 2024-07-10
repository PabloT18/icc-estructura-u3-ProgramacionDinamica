import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startime, endtime = 0;
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");

        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");

        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");

        /// Ejericio 1
        // runEjercicio();

    }

    // FORMA NORMAL RECURSIVA
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // PRIMERA FORMA DE HACERLO CON MEMORIA

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int fibonacciWithCaching(int n) {
        if (n <= 1) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = fibonacciWithCaching(n - 1) + fibonacciWithCaching(n - 2);
        cache.put(n, result);
        return result;
    }

    // SEGUNADA FORMA DE HACERLO CON MEMORIA

    // Método para calcular el n-ésimo número de la secuencia de Fibonacci
    public static int fibonacciCaching(int n) {
        int[] cache = new int[n + 1]; // Utilizamos un arreglo para almacenar los resultados previamente calculados
        return fibonacciMemoria(n, cache);
    }

    // Método auxiliar para calcular el n-ésimo número de Fibonacci utilizando
    // memorizaci
    private static int fibonacciMemoria(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        // Si el valor ya fue calculado previamente, lo retornamos desde el caché
        if (cache[n] != 0) {
            return cache[n];
        }
        // Si el valor no ha sido calculado, lo calculamos recursivamente y lo
        // almacenamos en el caché
        cache[n] = fibonacciMemoria(n - 1, cache) + fibonacciMemoria(n - 2, cache);
        return cache[n];
    }

    public static void runEjercicio() {

        // boolean[][] grid = {
        // { true, true, true, true },
        // { false, false, false, true },
        // { true, true, false, true },
        // { true, true, false, true }
        // };

    }
}
