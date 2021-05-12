
public class ComisVoiajor {

	private static String[] towns = new String[] { "A", "B", "C", "D" };

	private static int[][] connections = new int[][] { { 0, 1, 0, 1 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 0 } };

	private static int[] solution = new int[towns.length];

	public static void main(String[] args) {
		road(0);
	}

	private static void road(int k) {// k - pozitia elementului curent
		for (int i = 0; i < towns.length; i++) {
			solution[k] = i;
			if (valid(k)) {
				if (solution(k)) {
					afisare();
				} else {
					road(k + 1);
				}
			}
		}
	}

	private static void afisare() {
		for (int i = 0; i < solution.length; i++) {
			System.out.print(towns[solution[i]] + "->");
		}
		System.out.println();
	}

	private static boolean solution(int k) {
		return k == solution.length - 1;
	}

	private static boolean valid(int k) {
		if (k == 0)
			return true;
		for (int i = 0; i < k; i++) {
			if (solution[i] == solution[k]) {
				return false;
			}
		}
		for (int i = 0; i < k - 1; i++) {
			if (connections[solution[i]][solution[i + 1]] == 0) {
				return false;
			}
		}

		if (k == solution.length - 1 && connections[solution[k]][solution[0]] == 0) {
			return false;

		}
		return true;
	}
}
