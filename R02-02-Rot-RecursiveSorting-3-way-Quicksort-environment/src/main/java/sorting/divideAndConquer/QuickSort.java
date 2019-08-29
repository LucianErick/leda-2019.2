package sorting.divideAndConquer;

import sorting.AbstractSorting;

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
			if (leftIndex < rightIndex) {
				int posicaoPivot = separar(array, leftIndex, rightIndex);

				sort(array, leftIndex, posicaoPivot - 1);
				sort(array, posicaoPivot + 1, rightIndex);
			}
	}

	private void separar(T[] vector, int ini, int end) {
		int i = ini;
		int j = end;
		T pivot = vector[ini];

		while (i <= j) {
			if (vector[i].compareTo(pivot) <= 0) { i++;}
			else if (vector[j].compareTo(pivot) > 0) {j--;}
			else if (i <=)
		}
	}
}
