# Fibonacci, Quantas Chamadas? - 1029

# [Descrição](https://judge.beecrowd.com/pt/problems/view/1029)

Quase todo estudante de Ciência da Computação recebe em algum momento no início de seu curso de graduação algum problema envolvendo a sequência de Fibonacci.
Tal sequência tem como os dois primeiros valores 0 (zero) e 1 (um) e cada próximo valor será sempre a soma dos dois valores imediatamente anteriores. 
Por definição, podemos apresentar a seguinte fórmula para encontrar qualquer número da sequência de Fibonacci:
fib(0) = 0
fib(1) = 1
fib(n) = fib(n-1) + fib(n-2);

Uma das formas de encontrar o número de Fibonacci é através de chamadas recursivas. 
Isto é ilustrado a seguir, apresentando a árvore de derivação ao calcularmos o valor fib(4), ou seja o 5º valor desta sequência:


Desta forma,
fib(4) = 1+0+1+1+0 = 3
Foram feitas 8 calls, ou seja, 8 chamadas recursivas.

## Entrada
A primeira linha da entrada contém um único inteiro N, indicando o número de casos de teste. Cada caso de teste contém um inteiro X (1 ≤ X ≤ 39) .

## Saída
Para cada caso de teste de entrada deverá ser apresentada uma linha de saída, 
no seguinte formato: fib(n) = num_calls calls = result, aonde num_calls é o número de chamadas recursivas, tendo sempre um espaço antes e depois do sinal de igualdade, 
conforme o exemplo abaixo.

# Java 19

```java
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
```
