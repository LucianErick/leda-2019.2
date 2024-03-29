package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {

      int i, j;
      T atual;
      for (i = leftIndex; i <= rightIndex; i++) {
         atual = array[i];
         j = i;
         while (j > 0 && array[j - 1].compareTo(atual) > 0) {
            array[j] = array[j - 1];
            j--;
         }
         array[j] = atual;
      }
   }
}
