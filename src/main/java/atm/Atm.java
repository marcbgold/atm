package atm;

public class Atm {

	private double balance;
	private String requiredPin;

	public Atm() {
		this("1234", 500.00);
	}

	public Atm(String pin, double amount) {
		requiredPin = pin;
		this.balance = amount;
	}

	public double getBalance() {
		return balance;
	}

	public boolean withdraw(int amount) {
		if (amount > balance)
			return false;
		balance -= amount;
		return true;

	}

	public boolean deposit(int amount) {
		balance += amount;
		return true;
	}

	public String getPin() {
		return requiredPin;
	}

	public boolean allowAccess(String enteredPin) {
		return requiredPin.equals(enteredPin);
	}

}
