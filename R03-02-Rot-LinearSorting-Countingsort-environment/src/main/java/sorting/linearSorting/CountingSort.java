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

		// Descobrindo o maior elemento da sequencia.
		int maior = 0;
		for (int i = leftIndex; i < rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}

		Integer[] auxiliar = new Integer[maior];

		// Registrando a frequencia com que um elemento aparece na sequencia.
		for (int i = leftIndex; i < rightIndex; i++) {
			auxiliar[array[i] - 1] += 1;
		}

		// Fazendo a soma cumulativa no array auxiliar.
		for (int i = 0; i < auxiliar.length; i++) {
			auxiliar[i] += auxiliar[i - 1];
		}

		Integer[] arrayOrdenado = new Integer[array.length];
		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayOrdenado[auxiliar[array[i] - 1] - 1] = array[i];

		}
	}
}

