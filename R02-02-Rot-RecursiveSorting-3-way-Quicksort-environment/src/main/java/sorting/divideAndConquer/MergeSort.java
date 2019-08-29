package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);

			merge(array, leftIndex, mid, rightIndex);
		}

	}

	private void merge(T[] vector, int ini, int mid, int end) {

		T[] aux =(T[]) new Comparable[vector.length];

		for (int i = 0; i < vector.length; i++) { // Copia do vetor para um array auxiliar.
			aux[i] = vector[i];
		}

		int i = ini;
		int j = mid + 1;
		int k = ini;

		while (i <= mid && j <= end) {
			if (aux[i].compareTo(aux[j]) < 0) {
				vector[k] = aux[i];
				i++;
			} else {
				vector[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			vector[k] = aux[i];
			i++;
			k++;
		}

		while (j <= end) {
			vector[k] = aux[j];
			j++;
			k++;
		}

	}
}

