package inventory;

public class Item {

	public String name;
	private int value;// TODO add gold
	public int quantity;
	public int dropChance;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getDropChance() {
		return dropChance;
	}

	public void setDropChance(int dropChance) {
		this.dropChance = dropChance;
	}

	protected int stackAmt;
	protected int stackMax;
	protected int healAmt;

	public int getHealAmt() {
		return healAmt;
	}

	public void setHealAmt(int healAmt) {
		this.healAmt = healAmt;
	}

	public String getName() {
		return name;
	}

	public int getStackAmt() {
		return stackAmt;
	}

	public void setStackAmt(int stackAmt) {
		this.stackAmt = stackAmt;
	}

	public int getStackMax() {
		return stackMax;
	}

	public void setStackMax(int stackMax) {
		this.stackMax = stackMax;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
