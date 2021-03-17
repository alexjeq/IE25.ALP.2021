import java.util.Arrays;

public class SortNumbers {

	public static void main(String[] args) {

		int[] toSort = Util.genereazaVector(1, 100, 5);
		int[] toSort2 = toSort.clone();
		int[] toSort3 = toSort.clone();
		int[] toSort4 = toSort.clone();
		int[] toSort5 = toSort.clone();
		int[] toSort6 = toSort.clone();
		final int convert = 1000;

		System.out.println(Arrays.toString(toSort) + "\n");

		long start = System.nanoTime();
		selectSort(toSort2, "asc");
		long stop = System.nanoTime();
		System.out.println("Select sort:");
		System.out.println(Arrays.toString(toSort2));
		System.out.println("Durata = " + (stop - start) / convert + "n/" + convert + "\n");

		start = System.nanoTime();
		bubbleSort(toSort, "asc");
		stop = System.nanoTime();
		System.out.println("Buble sort:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		bubbleSortFor(toSort5, "asc");
		stop = System.nanoTime();
		System.out.println("Buble sort with For:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		insertSort(toSort3, "asc");
		stop = System.nanoTime();
		System.out.println("Insert sort:");
		System.out.println(Arrays.toString(toSort3));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		mergeSort(toSort4, 0, toSort4.length - 1);
		stop = System.nanoTime();
		System.out.println("Merge sort:");
		System.out.println(Arrays.toString(toSort4));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		Arrays.sort(toSort6);
		stop = System.nanoTime();
		System.out.println("Array sort:");
		System.out.println(Arrays.toString(toSort6));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert);
	}

	private static void bubbleSort(int[] toSort, String typeSort) {
		boolean ordonat = false;
		int ultimul = toSort.length - 1;
		while (!ordonat) {
			if (typeSort == "asc") {
				ordonat = true;
				int ultimulIndex = ultimul;
				for (int i = 0; i < ultimul; i++) {
					boolean compareResult = toSort[i + 1] < toSort[i];
					if (typeSort == "desc") {
						compareResult = toSort[i + 1] > toSort[i];
					}
					if (compareResult) {
						int aux = toSort[i + 1];
						toSort[i + 1] = toSort[i];
						toSort[i] = aux;
						ordonat = false;
						ultimulIndex = i;
					}
				}
				ultimul = ultimulIndex;
			}
		}
	}

	private static void bubbleSortFor(int[] toSort, String typeSort) {

		boolean ordonat = false;
		int ultimul = toSort.length - 1;

		for (int j = 0; j < toSort.length - 1; j++) {
			if (!ordonat) {
				if (typeSort == "asc") {
					ordonat = true;
					int ultimulIndex = ultimul;
					for (int i = 0; i < ultimul; i++) {
						boolean compareResult = toSort[i + 1] < toSort[i];
						if (typeSort == "desc") {
							compareResult = toSort[i + 1] > toSort[i];
						}
						if (compareResult) {

							int aux = toSort[i + 1];
							toSort[i + 1] = toSort[i];
							toSort[i] = aux;
							ordonat = false;
							ultimulIndex = i;
						}
					}
					ultimul = ultimulIndex;
				}
			} else
				return;
		}
	}

	private static void selectSort(int[] toSort, String typeSort) {
		for (int i = 0; i < toSort.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < toSort.length; j++) {
				boolean compareResult = toSort[j] < toSort[minIndex];
				if (typeSort == "desc") {
					compareResult = toSort[j] > toSort[minIndex];
				}
				if (compareResult) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = toSort[minIndex];
				toSort[minIndex] = toSort[i];
				toSort[i] = temp;
			}
		}
	}

	private static void insertSort(int[] toSort, String typeSort) {
		for (int i = 1; i < toSort.length; i++) {
			int curent = toSort[i];
			int j = i - 1;
			boolean compareResult = curent < toSort[j];
			if (typeSort == "desc") {
				compareResult = curent > toSort[j];
			}
			while (j >= 0 && compareResult) {
				toSort[j + 1] = toSort[j];
				j--;
			}
			toSort[j + 1] = curent;
		}
	}

	private static void mergeSort(int[] toSort, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(toSort, left, middle);
			mergeSort(toSort, middle + 1, right);
			merge(toSort, left, middle, right);
		}
	}

	private static void merge(int[] toSort, int left, int middle, int right) {
		int[] leftValues = new int[middle - left + 1];
		int[] rightValues = new int[right - middle];

		for (int i = 0; i < leftValues.length; i++) {
			leftValues[i] = toSort[left + i];
		}
		for (int i = 0; i < rightValues.length; i++) {
			rightValues[i] = toSort[middle + 1 + i];
		}
		int j = 0, k = 0, l = left;
		while (j < leftValues.length && k < rightValues.length) {
			if (leftValues[j] < rightValues[k]) {
				toSort[l] = leftValues[j];
				j++;
			} else {
				toSort[l] = rightValues[k];
				k++;
			}
			l++;
		}
		while (j < leftValues.length) {
			toSort[l] = leftValues[j];
			j++;
			l++;
		}
		while (k < rightValues.length) {
			toSort[l] = rightValues[k];
			k++;
			l++;
		}
	}
}
