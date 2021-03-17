import java.io.IOException;
import java.util.Arrays;

public class SortStrings {
	public static void main(String[] args) throws IOException {

		String[] toSort = Util.readFromFile("toSort.txt"); //file is in folder Sortare
		String[] toSort2 = toSort.clone();
		String[] toSort3 = toSort.clone();
		String[] toSort4 = toSort.clone();

		final int convert = 1000;

		System.out.println("List to sort:");
		System.out.println(Arrays.toString(toSort) + "\n");

		long start = System.nanoTime();
		bubbleSort(toSort, "asc");
		long stop = System.nanoTime();
		System.out.println("Buble sort:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		selectSort(toSort2, "asc");
		stop = System.nanoTime();
		System.out.println("Select sort:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");

		start = System.nanoTime();
		insertSort(toSort3, "asc");
		stop = System.nanoTime();
		System.out.println("Insert sort:");
		System.out.println(Arrays.toString(toSort));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");
		
		start = System.nanoTime();
		Arrays.sort(toSort4);
		stop = System.nanoTime();
		System.out.println("Array sort:");
		System.out.println(Arrays.toString(toSort4));
		System.out.println("Durata = " + (stop - start) / convert + "ns/" + convert + "\n");
		
		
	}

	private static void bubbleSort(String[] toSort, String typeSort) {
		boolean ordonat = false;
		int ultimul = toSort.length - 1;
		while (!ordonat) {
			ordonat = true;
			int ultimulIndex = ultimul;
			for (int i = 0; i < ultimul; i++) {
				boolean compareResult = toSort[i].compareTo(toSort[i + 1]) > 0;
				if (typeSort == "desc") {
					compareResult = toSort[i].compareTo(toSort[i + 1]) < 0;
				}
				if (compareResult) {
					String aux = toSort[i + 1];
					toSort[i + 1] = toSort[i];
					toSort[i] = aux;
					ordonat = false;
					ultimulIndex = i;
				}
			}
			ultimul = ultimulIndex;
		}
	}

	private static void selectSort(String[] toSort, String typeSort) {
		for (int i = 0; i < toSort.length; i++) {

			int minIndex = i;
			for (int j = i + 1; j < toSort.length; j++) {
				boolean compareResult = toSort[i].compareTo(toSort[i + 1]) > 0;
				if (typeSort == "desc") {
					compareResult = toSort[i].compareTo(toSort[i + 1]) < 0;
				}
				if (compareResult) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				String temp = toSort[minIndex];
				toSort[minIndex] = toSort[i];
				toSort[i] = temp;
			}
		}
	}

	private static void insertSort(String[] toSort, String typeSort) {
		for (int i = 1; i < toSort.length; i++) {
			String curent = toSort[i];
			int j = i - 1;
			boolean compareResult = curent.compareTo(toSort[j]) > 0;
			if (typeSort == "desc") {
				compareResult = curent.compareTo(toSort[j]) < 0;
			}
			while (j >= 0 && compareResult) {
				toSort[j + 1] = toSort[j];
				j--;
			}
			toSort[j +1] = curent;
		}
	}
}
