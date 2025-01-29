#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

char* strrev(const char *original) {
    int length = strlen(original);
    char *reversed = malloc((length + 1) * sizeof(char)); 
    if (reversed == NULL) {
        return NULL;
    }
    int j = 0;
    for (int i = length - 1; i >= 0; i--) {
        reversed[j++] = original[i];
    }
    reversed[j] = '\0'; 
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
