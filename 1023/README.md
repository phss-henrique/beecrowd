
# Estiagem - 1023 

# [Descrição](https://judge.beecrowd.com/pt/problems/view/1023)

Devido às constantes estiagens que aconteceram nos últimos tempos em algumas regiões do Brasil, o governo federal criou um órgão para a avaliação do consumo destas regiões com finalidade de verificar o comportamento da população na época de racionamento. 
Este órgão responsável irá pegar algumas cidades (por amostragem) e verificará como está sendo o consumo de cada uma das pessoas da cidade e o consumo médio de cada cidade por habitante.

## Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém um inteiro N (1 ≤ N ≤ 1*106), indicando a quantidade de imóveis.
As N linhas contém um par de valores X (1 ≤ X ≤ 10) e Y (1 ≤ Y ≤ 200), indicando a quantidade de moradores de cada imóvel e o respectivo consumo total de cada imóvel (em m3). Com certeza, nenhuma residência consome mais do que 200 m3 por mês.
O final da entrada é representado pelo número zero.

## Saída
Para cada entrada, deve-se apresentar a mensagem “Cidade# n:”, onde n é o número da cidade seguindo a sequência (1, 2, 3, ...) e em seguida deve-se listar, por ordem ascendente de consumo,
a quantidade de pessoas seguido de um hífen e o consumo destas pessoas, arredondando o valor para baixo. Na terceira linha da saída deve-se mostrar o consumo médio por pessoa da cidade, com 2 casas decimais sem arredondamento, considerando o consumo real total. 
Imprimir uma linha em branco entre dois casos de teste consecutivos. No fim da saída não deve haver uma linha em branco.


# Java 19

```java

import java.io.IOException;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int c = 1;

        while (true) {
            int lines = sc.nextInt();
            if (lines == 0) break;

            Map<Integer, Integer> consumoPorPessoa = new TreeMap<>();
            int totalPessoas = 0;
            int totalConsumo = 0;

            for (int i = 0; i < lines; i++) {
                int pessoas = sc.nextInt();
                int consumo = sc.nextInt();

                int consumoPorPessoaAtual = consumo / pessoas; 
                totalPessoas += pessoas;
                totalConsumo += consumo;

                consumoPorPessoa.put(consumoPorPessoaAtual, 
                    consumoPorPessoa.getOrDefault(consumoPorPessoaAtual, 0) + pessoas);
            }
            String b = (c > 1) ? "\n" : "";
            System.out.println(b+"Cidade# " + c + ":");
            List<String> resultado = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : consumoPorPessoa.entrySet()) {
                resultado.add(entry.getValue() + "-" + entry.getKey());
            }
            System.out.println(String.join(" ", resultado));

            //float consumoMedio = Math.floor((100.0*totalConsumo) / totalPessoas) / 100.0;
            System.out.printf("Consumo medio: %.2f m3.\n", Math.floor((100.0*totalConsumo) / totalPessoas) / 100.0);
            c++;
        }
    }
}
```
