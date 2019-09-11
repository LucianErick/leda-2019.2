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
		int maiorElemento = 0;
		int menorElemento = 1000000;
		for (int i = leftIndex; i < rightIndex; i++) {
			if (array[i] > maiorElemento) {
				maiorElemento = array[i];
			}

			if (array[i] < menorElemento) {
				menorElemento = array[i];
			}
		}

		int[] auxiliar = new int[maiorElemento];

		// Registrando a frequencia com que um elemento aparece na sequencia.
		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[array[i] - menorElemento] += 1;
		}

		// Fazendo a soma cumulativa no array auxiliar.
		for (int i = 1; i < auxiliar.length; i++) {
			auxiliar[i] += auxiliar[i - menorElemento];
		}

		// Colocando os elementos em ordem, a partir da análise da cumulativa.
		Integer[] arrayOrdenado = new Integer[array.length];
		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayOrdenado[auxiliar[array[i] - menorElemento] - menorElemento] = array[i];
			auxiliar[array[i] - menorElemento] -= 1;
		}

		for (int i = 0; i <= rightIndex; i++) {
			array[i] = arrayOrdenado[i];
		}
	}
}