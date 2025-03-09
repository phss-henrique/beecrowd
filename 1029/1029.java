import java.io.IOException;
import java.util.*;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */

public class Main {
    static int calls = 0;
    public static void main(String[] args) throws IOException {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test>0){
            calls = 0;
            int x = sc.nextInt();
            result = fibo(x);
            System.out.println("fib("+x+")"+" = "+(calls-1)+ " calls = "+result);
            test--;
            }

    }
        public static int fibo(int x){
            return calcFibo(x);
        }
        public static int calcFibo(int x){
            calls++;
            if(x == 1) return 1;
            if(x == 0) return 0;
            return calcFibo(x-1) + calcFibo(x-2);
        }
 
}
