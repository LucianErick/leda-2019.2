package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;

import static util.Util.swap;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot.
	 * <p>
	 * Considerando um array com muitos elementos repetidos, a estrategia do quicksort
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 * * arr[l..i] contem elementos menores que o pivot
	 * * arr[i+1..j-1] contem elementos iguais ao pivot.
	 * * arr[j..r] contem elementos maiores do que o pivot.
	 * <p>
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente.
	 **/

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= rightIndex) return;

		int pos_pivot = particiona(array, leftIndex, rightIndex);
		sort(array, leftIndex, pos_pivot - 1); // Ordena-se recursivamente o lado esquerdo do pivô
		sort(array, pos_pivot + 1, rightIndex); // Ordena-se recursivamente o lado direito do pivô

	}

	public int particiona(T[] vetor, int inicio, int fim) {
		int i = inicio + 1;
		int j = fim;
		T pivot = vetor[inicio]; // Definimos o pivô como sendo o valor do indice inicial.

		while (i <= j) {
			if (vetor[i].compareTo(pivot) <= 0) {
				i++;
			} else if (vetor[j].compareTo(pivot) > 0) {
				j--;
			} else if (i <= j) {
				swap(vetor, i, j);
				i++;
				j--;
			}
		}
	swap(vetor, inicio, j);
		return j;
	}
}