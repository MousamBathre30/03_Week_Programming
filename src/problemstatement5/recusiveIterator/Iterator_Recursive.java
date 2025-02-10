package problemstatement5.recusiveIterator;

public class Iterator_Recursive {
    // method for Recursive Fib...
    public static int fibonacciRecursive(int n){
       if(n <= 1){
           return n;
       }
      return  fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
   // method for Iterator Fib...
    public static void fibonacciIterator(int n){
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
    }

    // Main Method
    public static void main(String[] args) {
        int n;
        n = 30;  // Customize the input
        double start = System.nanoTime();
        fibonacciRecursive(n);
        double end = System.nanoTime();
        double diff = (end - start)/1000000;
        System.out.println("The time take by Recursive " + diff + " ms");
        start = System.nanoTime();
        fibonacciIterator(n);
        end = System.nanoTime();
        diff = (end - start )/1000000 ;
        System.out.println("The time take by Iterator " + diff + " ms");
    }
}
