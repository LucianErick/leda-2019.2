package sorting.divideAndConquer;

import sorting.AbstractSorting;

import static util.Util.*;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) { // Enquanto o indice de inicio for menor que o final
			int pos_pivot = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, pos_pivot - 1); // Ordena-se recursivamente o lado esquerdo do pivô
			sort(array, pos_pivot + 1, rightIndex); // Ordena-se recursivamente o lado direito do pivô
		}
	}

	public int particiona(T[] vetor, int inicio, int fim) {

		T pivot = vetor[inicio]; // Definimos o pivô como sendo o valor do indice inicial.
		int i = inicio;

		for (int j = inicio + 1; j <= fim; j++) {
			if (vetor[j].compareTo(pivot) < 0) {
				i++;
				swap(vetor, i, j);
			}
		}
		swap(vetor, inicio, i);
		return i;
	}
}