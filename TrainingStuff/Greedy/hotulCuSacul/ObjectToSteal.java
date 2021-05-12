package hotulCuSacul;

public class ObjectToSteal {
	private double value;
	private double weight;

	public ObjectToSteal(double value, double weight) {
		this.value = value;
		this.weight = weight;
	}

	public ObjectToSteal(ObjectToSteal obj) {
		value = obj.value;
		weight = obj.weight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
