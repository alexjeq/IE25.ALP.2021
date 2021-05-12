package test;

public class ArrangeGuests {

	private static String[] guests = new String[] { "Ionel", "Maricica", "Bogdan", "Ioana", "Marin" };

	private static int[][] relations = new int[][] { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1 },
		{ 1, 1, 1, 0, 1 }, { 0, 0, 1, 1, 0 } };

	private static int[] solution = new int[guests.length];

	public static void main(String[] args) {
		arrange(0);
	}

	private static void arrange(int k) {// k - pozitia elementului curent
		for (int i = 0; i < guests.length; i++) {
			solution[k] = i;
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
		for (int i = 0; i < solution.length; i++) {
			System.out.printf("%8s",guests[solution[i]]);
			System.out.print(" - ");
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
	
			if (relations[solution[k-1]][solution[k]] == 0) {
				return false;
			}
			/*for (int i = 0; i < k - 1; i++) {
			if (relations[solution[i]][solution[i + 1]] == 0 || relations[solution[i+1]][solution[i]]==0) {
				return false;
			}
		}*/
		

		if (k == solution.length - 1 && relations[solution[k]][solution[0]] == 0) {
			return false;

		}
		return true;
	}

}
