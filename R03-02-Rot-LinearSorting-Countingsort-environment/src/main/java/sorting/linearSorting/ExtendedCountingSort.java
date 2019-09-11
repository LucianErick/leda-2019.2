package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		// Para um array de tamanho 1 ou mais...
		if(array.length > 0) {
			int menor = array[leftIndex];
			int maior = array[leftIndex];
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i] >= maior)
					maior = array[i];

				if (array[i] < menor)
					menor = array[i];
			}

			// Registra-se a frequencia em que cada elemento aparece.
			int[] auxiliar = new int[maior - menor + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				auxiliar[array[i] - menor] += 1; // semelhante a um 'shift' para direita, pois os elementos
			}									 // negativos entram tambem.

			// Registra-se a soma cumulativa dos indices ocupados do array auxiliar.
			for (int i = 1; i < auxiliar.length; i++) {
				array[i] += array[i - 1];
			}

			Integer[] arrayOrdenado = new Integer[array.length];
			for (int i = rightIndex; i <= leftIndex ; i--) {
				arrayOrdenado[auxiliar[array[i] - menor] - 1] = array[i];
				auxiliar[array[i] - menor] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrdenado[i];
			}
		}
	}
}
