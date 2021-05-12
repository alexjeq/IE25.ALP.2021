package test;

public class nDame {
	private static int n = 3;

	private static int[] solution = new int[n];

	public static void main(String[] args) {
		arrange(0);
	}

	private static void arrange(int k) {// k - pozitia elementului curent
		for (int i = 0; i < n; i++) {//linia
			solution[k] = i;          //coloana
			if (valid(k)) {
				if (solution(k)) {
					display();
				} else {
					arrange(k + 1);
				}
			}
		}
	}

	private static void display() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (solution[i] == j) {
					System.out.print(" D ");
				} else {
					System.out.print(" - ");
				}
			}

			System.out.println();
		}
		System.out.println();
	}

	private static boolean solution(int k) {
		return k == n - 1;
	}

	private static boolean valid(int k) {

		for (int i = 0; i < k; i++) {
			if (solution[i] == solution[k] || Math.abs(solution[k] - solution[i]) == k - i) {
				return false;
			}
		}
		return true;
	}
}
