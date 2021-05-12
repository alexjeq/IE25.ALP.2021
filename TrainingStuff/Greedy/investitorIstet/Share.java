package investitorIstet;

public class Share {
	private double amount;
	private double cost;
	private double dividend;

	public Share(double amount, double cost, double dividend) {
		this.amount = amount;
		this.cost = cost;
		this.dividend = dividend;
	}

	public Share(Share obj) {
		this.amount = obj.amount;
		this.cost = obj.cost;
		this.dividend = obj.dividend;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getDividend() {
		return dividend;
	}

	public void setDividend(double dividend) {
		this.dividend = dividend;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
