# As Frutas Esquecidas - 3161
[Descrição](https://judge.beecrowd.com/pt/problems/view/3161)

Sheldon Cooper é um personagem excêntrico existente no universo de Hollywood. Recentemente ele sofreu um acidente e acabou esquecendo quais frutas gosta de comer.
Contudo, é chegada a hora de preparar o café da manhã e Sheldon não quer passar pela experiência de provar uma fruta e descobrir que não gosta dela.
Então, incomodado com essa situação, Sheldon convenceu seu amigo Leonard Hofstadter a lhe ajudar. 
Leonard lembra do momento que conheceu Sheldon e devido as excentricidades de seu amigo, ele guardou em seu computador uma lista com o nome das frutas que Sheldon gosta de comer.
Leonard muito animado com sua sagacidade, abre o arquivo e observa que algo está errado: o conteúdo do arquivo foi embaralhado por um vírus de computador.
Determinado a resolve essa questão, Leonard fez experimentos e concluiu que é possível ler o conteúdo do arquivo e descobrir se Sheldon gosta ou não de uma dada fruta. 
Pelos experimentos, Leonard observou que o vírus fez alguma(s) das seguintes alterações: 
- Incluiu novos caracteres à esquerda e/ou à direita ao nome da fruta que estava na lista;
- Alterou algumas letras, neste caso, algumas se tornaram maiúsculas e outras minúsculas;
- O nome da fruta que estava na lista foi invertido ("Bergamota" => "Atomagreb").
Como Leonard estudou programação, ele irá criar um programa que recebe o nome de uma fruta e retorna se Sheldon gosta ou não dessa fruta.

## Entrada
A primeira linha contém dois inteiros: 
- N que representa a quantidade de nomes de frutas que será verificado/procurado, limitado por [1,100];
- M que representa a quantidade de linhas da lista de nomes das frutas, limitado por [15,500];
Além disso, cada linha M da lista de nomes e cada linha N com o nome de fruta seguem o limite: [4,100].

## Saída
Para cada nome de fruta procurado, informe: “Sheldon come a fruta X” ou “Sheldon detesta a fruta X” (onde X é nome da fruta que foi verificada na lista em lowercase).

# Código:
```C
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

char* strrev(const char *original) {
    int length = strlen(original);
    char *reversed = malloc((length + 1) * sizeof(char)); // Allocate memory for the reversed string
    if (reversed == NULL) {
        // Handle memory allocation failure
        return NULL;
    }
    int j = 0;
    for (int i = length - 1; i >= 0; i--) {
        reversed[j++] = original[i];
    }
    reversed[j] = '\0'; // Null-terminate the reversed string
    return reversed;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    
    char frutas[N][100];
    char frases[M][100];
    
    for(int i = 0; i < N; i++){
        scanf("%s", frutas[i]);
        for(int k = 0; frutas[i][k] != '\0'; k++){
            frutas[i][k] = tolower(frutas[i][k]);
        }        
    }
     for(int j = 0; j < M; j++){
        scanf("%s", frases[j]);
        for(int h = 0; frases[j][h] != '\0'; h++){
            frases[j][h] = tolower(frases[j][h]);
        }
     }
    
     for(int i = 0; i < N; i++){
         int found = 0;
        for(int j = 0; j < M; j++){
            char *reversed_frase = strrev(frases[j]);
            if(strstr(frases[j],frutas[i]) != NULL || strstr(reversed_frase, frutas[i]) != NULL) {
                printf("Sheldon come a fruta %s\n", frutas[i]);
                found = 1;
                break;
            } 
        }
            if(found == 0){
                printf("Sheldon detesta a fruta %s\n", frutas[i]);
            }
        
    }

    return 0;
}
```
