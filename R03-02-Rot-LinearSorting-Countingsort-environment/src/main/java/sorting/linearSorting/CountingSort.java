package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0) {
			// Descobrindo o maior e menor elementos da sequencia.
			int maior = array[leftIndex];
			int menor = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] >= maior) {
					maior = array[i];
				}
				if (array[i] < menor) {
					menor = array[i];
				}
			}

			int[] auxiliar = new int[maior - menor + 1];
			// Registrando a frequencia com que um elemento aparece na sequencia.
			for (int i = leftIndex; i <= rightIndex; i++) {
				auxiliar[array[i] - menor] += 1;
			}

			// Fazendo a soma cumulativa no array auxiliar.
			for (int i = 1; i < auxiliar.length; i++) {
				auxiliar[i] += auxiliar[i - 1];
			}

			// criando um novo vetor, com o intuito de ordena-lo, utilizando do original e do
			// vetor auxiliar.
			Integer[] arrayOrdenado = new Integer[array.length];
			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayOrdenado[auxiliar[array[i] - menor] - 1] = array[i];
				auxiliar[array[i] - menor] -= 1;
			}

			// fazendo uma copia, para o vetor original, do vetor ordenado.
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrdenado[i];
			}
		}
	}
}

