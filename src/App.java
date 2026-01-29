import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        runFibonaci();
        runFibonaciTD();
        runFibonaciBU();
        runFibonaciOp();
    }

    private static void runFibonaciOp() {
        Fibonaci fibonaciOp = new Fibonaci();
        int n = 47;
        System.out.println("FibonacciOp");
        long result = medirTiempo2(() -> fibonaciOp.fibOptimizado(n));
        System.out.println("Fibonacci of " + n + " is: " + result);
    }

    private static void runFibonaciBU() {
        Fibonaci fibonaciBU = new Fibonaci();
        int n = 47;
        System.out.println("FibonacciBU");
        long result = medirTiempo2(() -> fibonaciBU.fibonacciBU(n));
        System.out.println("Fibonacci of " + n + " is: " + result);
    }

    private static void runFibonaciTD() {
        Fibonaci fibonaci = new Fibonaci();
        int n = 47;
        System.out.println("FibonaccTD");
        long result = medirTiempo2(() -> fibonaci.fibonacciTD(n));
        System.out.println("Fibonacci of " + n + " is: " + result);
    }


    private static void runFibonaci() {
        Fibonaci fibonaci = new Fibonaci();
        long n = 47;
        long result = medirTiempo2(() -> fibonaci.fibonacci(n));
        System.out.println("Fibonacci of " + n + " is: " + result);
    }

    /// funcion que recibe otra
    /// la ejecuta
    /// y saca su tiempo de ejecucion
    /// y retorna lo que la funcion retonre
    /// 
    public static <T> T medirTiempo(Callable<T> funcion)  throws Exception{
        long startTime = System.nanoTime();
        
        T resultado = funcion.call();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println();
        System.out.println("Tiempo de ejecucion: " + duration / 1_000_000 + " nanosegundos" );

        return resultado;
    }

    public static <T> T medirTiempo2(Supplier<T> funcion){
        long startTime = System.nanoTime();
        
        T resultado = funcion.get();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Tiempo de ejecucion: " + (duration/1_000_000_000.0) + " segundos");
        
        return resultado;
        
    }
    
}
