# Análise de Desempenho de Algoritmos de Ordenação

Este repositório implementa e analisa o desempenho de 6 algoritmos de ordenação em Java (Bubble, Selection, Cocktail, Gnome, Comb e Bucket Sort). O objetivo é comparar suas métricas de eficiência (trocas e iterações) em três cenários de dados distintos.

O código-fonte da implementação e da análise está no arquivo `AnalisadorDeAlgoritmos.java`.

## Métricas de Análise

A comparação foi realizada com base em duas métricas principais:

1.  **Trocas:** O número de vezes que dois elementos trocaram de posição.
2.  **Iterações:** O número total de ciclos de loops (internos e externos) executados, servindo como uma medida de complexidade de tempo.

##  Resultados da Análise

Os algoritmos foram executados em três vetores de 20 elementos:
* **Vetor 1 (Aleatório):** `{12, 18, 9, ...}`
* **Vetor 2 (Ordenado):** `{5, 7, 9, ...}`
* **Vetor 3 (Invertido):** `{99, 85, 73, ...}`

### Tabela 1: Ranking por TROCAS (Menor é melhor)

| Algoritmo | Vetor 1 (Aleatório) | Vetor 2 (Ordenado) | Vetor 3 (Invertido) |
|:---|:---:|:---:|:---:|
| **Selection Sort** | **18 (1º)** | **0 (1º)** | **10 (1º)** |
| **Comb Sort** | 22 (2º) | **0 (1º)** | 18 (2º) |
| **Bucket Sort** | 22 (2º) | **0 (1º)** | 63 (3º) |
| **Bubble c/ Flag** | 78 (4º) | **0 (1º)** | 190 (4º) |
| **Cocktail Sort** | 78 (4º) | **0 (1º)** | 190 (4º) |
| **Gnome Sort** | 78 (4º) | **0 (1º)** | 190 (4º) |

### Tabela 2: Ranking por ITERAÇÕES (Menor é melhor)

| Algoritmo | Vetor 1 (Aleatório) | Vetor 2 (Ordenado) | Vetor 3 (Invertido) |
|:---|:---:|:---:|:---:|
| **Bucket Sort** | **97 (1º)** | 75 (4º) | **138 (1º)** |
| **Comb Sort** | 138 (2º) | 118 (5º) | **138 (1º)** |
| **Cocktail Sort** | 160 (3º) | **20 (1º)** | 200 (3º) |
| **Bubble c/ Flag** | 195 (4º) | **20 (1º)** | 209 (4º) |
| **Gnome Sort** | 350 (6º) | 39 (3º) | 780 (6º) |
| **Selection Sort** | 209 (5º) | 209 (6º) | 209 (4º) |

---

##  Conclusões e Análise

### Cenário 1: Vetor Aleatório (Vetor 1)

* **Melhor Desempenho:** O **Bucket Sort** foi o vencedor geral, sendo o mais rápido (97 iterações) e o segundo com menos trocas (22). O **Comb Sort** também foi excelente (2º em iterações, 2º em trocas). O **Selection Sort** se destacou por ser o que fez menos trocas (18).
* **Pior Desempenho:** O **Gnome Sort** foi o pior, sendo o mais lento (350 iterações) e empatado com o maior número de trocas (78).

### Cenário 2: Vetor Ordenado (Vetor 2)

* **Melhor Desempenho:** O **Bubble Sort com Flag** e o **Cocktail Sort** são os vencedores. Por serem "adaptativos", eles executam uma única passada, percebem que o vetor está ordenado e param imediatamente (20 iterações). O **Gnome Sort** também é adaptativo e teve um ótimo desempenho (39 iterações).
* **Pior Desempenho:** O **Selection Sort** é o pior neste cenário. Ele não é adaptativo e executa sua lógica $O(n^2)$ completa (209 iterações) desnecessariamente.

### Cenário 3: Vetor Invertido (Vetor 3)

* **Melhor Desempenho:** O **Comb Sort** e o **Bucket Sort** foram os mais rápidos, empatados com 138 iterações. O **Selection Sort** foi, de longe, o algoritmo com o menor número de trocas (apenas 10).
* **Pior Desempenho:** O **Gnome Sort** teve um colapso de desempenho, exigindo **780 iterações** (quase 4x mais que o Bubble Sort), tornando-o o pior algoritmo neste cenário. Os algoritmos baseados em Bubble (Bubble, Cocktail, Gnome) tiveram o maior número de trocas (190), pois esta é a pior configuração de dados para eles.
