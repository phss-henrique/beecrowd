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

            System.out.printf("Consumo medio: %.2f m3.\n", Math.floor((100.0*totalConsumo) / totalPessoas) / 100.0);
            c++;
        }
    }
}
