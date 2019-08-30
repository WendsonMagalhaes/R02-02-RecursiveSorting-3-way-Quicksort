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

		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			
			int middleIndex = ((leftIndex + rightIndex) / 2);
			this.sort(array, leftIndex, middleIndex);
			this.sort(array, middleIndex + 1, rightIndex);
			this.merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
		
		 T[] result = (T[]) new Comparable[array.length];

	        for (int i = leftIndex; i <= rightIndex; i++) {
	            result[i] = array[i];
	        }

	        int i = leftIndex;
	        int l = leftIndex;
	        int m = middleIndex + 1;

	        while (l <= middleIndex && m <= rightIndex) {
	        	
	            if (result[l].compareTo(result[m]) < 0) {
	                array[i] = result[l];
	                l++;
	            } else {
	                array[i] = result[m];
	                m++;
	            }

	            i++;
	        }

	        while (l <= middleIndex) {
	            array[i] = result[l];
	            l++;
	            i++;
	        }

	        while (m <= rightIndex) {
	            array[i] = result[m];
	            m++;
	            i++;
	        }
	    }
	}
