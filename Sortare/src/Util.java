import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {
	public static int[] genereazaVector(int min, int max, int n) {
		int[] generat = new int[n];

		Random rnd = new Random();
		for (int i = 0; i < generat.length; i++) {
			generat[i] = min + rnd.nextInt(max - min);
		}
		return generat;
	}

	public static String[] readFromFile(String input) throws FileNotFoundException {
		int size = 0;
		Scanner readerForSize = new Scanner(new File(input));
		while (readerForSize.hasNextLine()) {
			readerForSize.nextLine();
			size++;
		}
		readerForSize.close();
		String[] words = new String[size];
		Scanner readerWords = new Scanner(new File(input));
		for (int i = 0; i < size; i++) {
			words[i] = readerWords.nextLine();
		}
		readerWords.close();
		return words;
	}

	public static String[] readFromFile2(String input) throws FileNotFoundException {
		ArrayList<String> words1 = new ArrayList<>();
		Scanner reader1 = new Scanner(new File(input));
		while (reader1.hasNext()) {
			words1.add(reader1.nextLine());
		}
		reader1.close();
		String[] words = words1.toArray(new String[0]);
		return words;
	}
}
