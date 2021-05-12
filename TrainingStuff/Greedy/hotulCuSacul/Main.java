package hotulCuSacul;

public class Main {

	private static final double bagVolume = 6;

	private static ObjectToSteal[] objects = new ObjectToSteal[] { new ObjectToSteal(2, 1), new ObjectToSteal(1, 1),
			new ObjectToSteal(10, 4), new ObjectToSteal(2, 2), new ObjectToSteal(4, 12) };

	private static ObjectToSteal[] bag = new ObjectToSteal[] { new ObjectToSteal(0, 0), new ObjectToSteal(0, 0),
			new ObjectToSteal(0, 0), new ObjectToSteal(0, 0), new ObjectToSteal(0, 0) };

	public static void main(String[] args) {
		putInBag();
	}

	private static void putInBag() {
		order(objects);
		for (int i = 0; i < objects.length; i++) {
			if (i > 0 && solution()) {
				break;
			}
			double currentWeight = countWeight();
			bag[i] = new ObjectToSteal(objects[i]);
			if (bag[i].getWeight() + currentWeight > bagVolume) {
				bag[i].setWeight(bagVolume - currentWeight);
			}
		}
		if (solution()) {
			printSolution();
		} else {
			System.out.println("There is no solution.");
		}
	}

	private static void printSolution() {
		for (int i = 0; i < bag.length; i++) {
			if (bag[i].getWeight() == 0) {
				break;
			}
			if (i > 0) {
				System.out.print(" -> ");
			}
			System.out.print("(" + bag[i].getValue() + ";" + bag[i].getWeight() + ")");
		}
	}

	private static double countWeight() {
		double weight = 0;
		for (int i = 0; i < bag.length; i++) {
			weight += bag[i].getWeight();
		}
		return weight;
	}

	private static boolean solution() {
		double currentWeight = countWeight();
		return currentWeight == bagVolume || bag[bag.length - 1].getWeight() == objects[objects.length - 1].getWeight();
	}

	private static void order(ObjectToSteal[] objectsToSort) {
		for (int i = 1; i < objectsToSort.length; i++) {
			ObjectToSteal current = new ObjectToSteal(objectsToSort[i]);
			int j = i - 1;
			while (j >= 0 && objectsToSort[j].getValue() / objectsToSort[j].getWeight() < current.getValue()
					/ current.getWeight()) {
				objectsToSort[j + 1] = new ObjectToSteal(objectsToSort[j]);
				j--;
			}
			objectsToSort[j + 1] = new ObjectToSteal(current);
		}
	}
}
