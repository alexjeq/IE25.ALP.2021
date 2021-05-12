package investitorIstet;

public class Main {

	private static final double sumToInvest = 3000;

	private static Share[] typesOfShares = new Share[] { new Share(100, 10, 12), new Share(50, 15, 20),
			new Share(80, 13, 14), new Share(70, 20, 30) };

	private static Share[] boughtShares = new Share[] { new Share(0, 0, 0), new Share(0, 0, 0), new Share(0, 0, 0),
			new Share(0, 0, 0) };

	public static void main(String[] args) {
		buyShares();
	}

	private static void buyShares() {
		order(typesOfShares);
		for (int i = 0; i < typesOfShares.length; i++) {
			if (i > 0 && solution()) {
				break;
			}
			double spentMoney = countSpentMoney();
			boughtShares[i] = new Share(typesOfShares[i]);
			if (typesOfShares[i].getCost() * typesOfShares[i].getAmount() + spentMoney > sumToInvest) {
				boughtShares[i].setAmount((sumToInvest - spentMoney) / typesOfShares[i].getCost());
			}
		}
		if (solution()) {
			printSolution();
		} else {
			System.out.println("There is no Solution.");
		}

	}

	private static void printSolution() {
		for (int i = 0; i < boughtShares.length; i++) {
			if (boughtShares[i].getAmount() == 0) {
				break;
			}
			System.out.printf("%.0f", boughtShares[i].getAmount());
			System.out.print(" shares of ");
			System.out.printf("%.2f", boughtShares[i].getCost());
			System.out.print(" $ cost/share and ");
			System.out.printf("%.2f", boughtShares[i].getDividend());
			System.out.println(" $ devidend/share;");
		}
	}

	private static double countSpentMoney() {
		double spentMoney = 0;
		for (int i = 0; i < boughtShares.length; i++) {
			spentMoney += boughtShares[i].getAmount() * boughtShares[i].getCost();
		}
		return spentMoney;
	}

	private static boolean solution() {
		double spentMoney = countSpentMoney();
		return spentMoney == sumToInvest || boughtShares[boughtShares.length - 1]
				.getAmount() == typesOfShares[typesOfShares.length - 1].getAmount();
	}

	private static void order(Share[] sharesToSort) {
		for (int i = 1; i < sharesToSort.length; i++) {
			Share current = new Share(sharesToSort[i]);
			int j = i - 1;
			while (j >= 0 && (sharesToSort[j].getDividend() - sharesToSort[j].getCost()) < (current.getDividend()
					- current.getCost())) {
				sharesToSort[j + 1] = new Share(sharesToSort[j]);
				j--;
			}
			sharesToSort[j + 1] = new Share(current);
		}

	}

}
