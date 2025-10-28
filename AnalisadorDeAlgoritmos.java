public class AnalisadorDeAlgoritmos {

    public static final int TAMANHO_FIXO = 20;

    static class Metricas {
        int trocas;
        int iteracoes;
        int[] vetorOrdenado;
      
        Metricas(int trocas, int iteracoes, int[] vetorOrdenado) {
            this.trocas = trocas;
            this.iteracoes = iteracoes;
            this.vetorOrdenado = vetorOrdenado;
        }
    }

    public static int[] clonarVetor(int[] original) {
        int[] destino = new int[TAMANHO_FIXO];
        for (int i = 0; i < TAMANHO_FIXO; i++) {
            destino[i] = original[i];
        }
        return destino;
    }

    public static Metricas bubbleSortComFlag(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;
        boolean trocou;

        for (int i = 0; i < TAMANHO_FIXO - 1; i++) {
            iteracoes++;
            trocou = false;
            
            for (int j = 0; j < TAMANHO_FIXO - 1 - i; j++) {
                iteracoes++;
                if (copia[j] > copia[j + 1]) {
                    int temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            
            if (trocou == false) {
                break;
            }
        }
        return new Metricas(trocas, iteracoes, copia);
    }
   
    public static Metricas selectionSort(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;

        for (int i = 0; i < TAMANHO_FIXO - 1; i++) {
            iteracoes++;
            int idxMenor = i;
            
            for (int j = i + 1; j < TAMANHO_FIXO; j++) {
                iteracoes++;
                if (copia[j] < copia[idxMenor]) {
                    idxMenor = j;
                }
            }
            
            if (idxMenor != i) {
                int temp = copia[i];
                copia[i] = copia[idxMenor];
                copia[idxMenor] = temp;
                trocas++;
            }
        }
        return new Metricas(trocas, iteracoes, copia);
    }
   
    public static Metricas cocktailSort(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;

        int inicio = 0;
        int fim = TAMANHO_FIXO - 1;
        boolean trocou = true;

        while (trocou) {
            iteracoes++;
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                iteracoes++;
                if (copia[i] > copia[i + 1]) {
                    int temp = copia[i];
                    copia[i] = copia[i + 1];
                    copia[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (trocou == false) {
                break;
            }
            
            trocou = false;
            fim--;
            
            for (int i = fim - 1; i >= inicio; i--) {
                iteracoes++;
                if (copia[i] > copia[i + 1]) {
                    int temp = copia[i];
                    copia[i] = copia[i + 1];
                    copia[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
        return new Metricas(trocas, iteracoes, copia);
    }
   
    public static Metricas gnomeSort(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;
        int indice = 0;
        
        while (indice < TAMANHO_FIXO) {
            iteracoes++;
            
            if (indice == 0) {
                indice++;
            } else if (copia[indice] >= copia[indice - 1]) {
                iteracoes++;
                indice++;
            } else {
                iteracoes++;
                int temp = copia[indice];
                copia[indice] = copia[indice - 1];
                copia[indice - 1] = temp;
                trocas++;
                indice--;
            }
        }
        return new Metricas(trocas, iteracoes, copia);
    }
   
    public static Metricas combSort(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;
       
        float fatorReducao = 1.3f;
        int gap = TAMANHO_FIXO;
        boolean trocou = true;

        while (gap > 1 || trocou) {
            iteracoes++;
            gap = (int)(gap / fatorReducao);
            if (gap < 1) {
                gap = 1;
            }
            
            trocou = false;
            
            for (int i = 0; i < TAMANHO_FIXO - gap; i++) {
                iteracoes++;
                if (copia[i] > copia[i + gap]) {
                    int temp = copia[i];
                    copia[i] = copia[i + gap];
                    copia[i + gap] = temp;
                    trocas++;
                    trocou = true;
                }
            }
        }
        return new Metricas(trocas, iteracoes, copia);
    }
   
    public static Metricas bucketSort(int[] original) {
        int[] copia = clonarVetor(original);
        int trocas = 0;
        int iteracoes = 0;
       
        if (TAMANHO_FIXO == 0) return new Metricas(0, 0, copia);
       
        iteracoes++;
        int minVal = copia[0];
        int maxVal = copia[0];
        for (int i = 1; i < TAMANHO_FIXO; i++) {
            iteracoes++;
            if (copia[i] < minVal) minVal = copia[i];
            if (copia[i] > maxVal) maxVal = copia[i];
        }
       
        int NUM_BALDES = 5;
        int[][] baldes = new int[NUM_BALDES][TAMANHO_FIXO];
        int[] tamanhoBaldes = new int[NUM_BALDES];
        
        for (int i = 0; i < NUM_BALDES; i++) {
            tamanhoBaldes[i] = 0;
        }
       
        int range = maxVal - minVal + 1;
        if (range <= 0) range = 1;

        for (int i = 0; i < TAMANHO_FIXO; i++) {
            iteracoes++;
            int valor = copia[i];
            
            int idxBalde = ( (valor - minVal) * NUM_BALDES ) / range;
            
            if (idxBalde >= NUM_BALDES) idxBalde = NUM_BALDES - 1;
            if (idxBalde < 0) idxBalde = 0;

            baldes[idxBalde][ tamanhoBaldes[idxBalde] ] = valor;
            tamanhoBaldes[idxBalde]++;
        }
       
        int[] resultado = new int[TAMANHO_FIXO];
        int pos = 0;
        
        for (int b = 0; b < NUM_BALDES; b++) {
            
            for (int i = 1; i < tamanhoBaldes[b]; i++) {
                iteracoes++;
                int chave = baldes[b][i];
                int j = i - 1;
                while (j >= 0 && baldes[b][j] > chave) {
                    iteracoes++;
                    baldes[b][j + 1] = baldes[b][j];
                    trocas++;
                    j--;
                }
                baldes[b][j + 1] = chave;
            }
            
            for (int i = 0; i < tamanhoBaldes[b]; i++) {
                iteracoes++;
                resultado[pos] = baldes[b][i];
                pos++;
            }
        }
        return new Metricas(trocas, iteracoes, resultado);
    }
   
    public static String formatarVetor(int[] vetor) {
        String str = "[";
        for (int i = 0; i < TAMANHO_FIXO; i++) {
            str = str + vetor[i];
            if (i < TAMANHO_FIXO - 1) {
                str = str + ", ";
            }
        }
        str = str + "]";
        return str;
    }
   
    public static void executarEImprimirAnalise(int[] vetor, String titulo) {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Vetor Original: " + formatarVetor(vetor));
        
        Metricas resBubble = bubbleSortComFlag(vetor);
        Metricas resSelection = selectionSort(vetor);
        Metricas resCocktail = cocktailSort(vetor);
        Metricas resGnome = gnomeSort(vetor);
        Metricas resComb = combSort(vetor);
        Metricas resBucket = bucketSort(vetor);
       
        System.out.println("Algoritmo      | Trocas | Iterações");
        System.out.println("---------------+--------+----------");
        
        System.out.printf("%-15s| %-6d | %-8d\n", "Bubble c/ Flag", resBubble.trocas, resBubble.iteracoes);
        System.out.printf("%-15s| %-6d | %-8d\n", "Selection", resSelection.trocas, resSelection.iteracoes);
        System.out.printf("%-15s| %-6d | %-8d\n", "Cocktail", resCocktail.trocas, resCocktail.iteracoes);
        System.out.printf("%-15s| %-6d | %-8d\n", "Gnome", resGnome.trocas, resGnome.iteracoes);
        System.out.printf("%-15s| %-6d | %-8d\n", "Comb", resComb.trocas, resComb.iteracoes);
        System.out.printf("%-15s| %-6d | %-8d\n", "Bucket", resBucket.trocas, resBucket.iteracoes);
        System.out.println();
    }
   
    public static void main(String[] args) {
        try {
            int[] arrAleatorio = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
            int[] arrOrdenado = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
            int[] arrInvertido = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
           
            executarEImprimirAnalise(arrAleatorio, "Cenário 1: Vetor Aleatório");
            executarEImprimirAnalise(arrOrdenado, "Cenário 2: Vetor Já Ordenado");
            executarEImprimirAnalise(arrInvertido, "Cenário 3: Vetor Invertido");
           
        } catch (Exception e) {
            System.out.println("Ocorreu uma exceção: " + e.getMessage());
            e.printStackTrace();
        }
    }
}