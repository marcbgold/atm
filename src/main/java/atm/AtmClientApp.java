package atm;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please create a PIN.");
		String pinInput = input.next().trim();
		Atm myAccount = new Atm(pinInput, 1000.00);
		String pin = "";

		System.out.println();
		System.out.println("Please enter your PIN.");
		pin = input.next().trim();
		int attemptCount = 0;

		while (!myAccount.allowAccess(pin) && attemptCount < 3) {
			attemptCount++;
			if (attemptCount >= 3) {
				System.out.println();
				System.out.println("Too many incorrect attempts.  Access denied.");
				System.exit(0);
			}
			System.out.println();
			System.out.println("Incorrect PIN.  Please try again.");
			pin = input.next().trim();
		}

		String choice = "";
		int amount;
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		System.out.println();
		System.out.println("Welcome. Please choose an option:");

		do {
			System.out.println();
			System.out.println("1. Deposit funds");
			System.out.println("2. Withdraw funds");
			System.out.println("3. Check balance");
			System.out.println("4. Quit");
			choice = input.next().trim();

			switch (choice) {
			case "1":
				System.out.println();
				System.out.println("Please enter how much you wish to deposit.");
				amount = input.nextInt();
				if (amount < 0) {
					System.out.println();
					System.out.println("Cannot deposit negative dollar values.");
				} else {
					myAccount.deposit(amount);
					System.out.println();
					System.out.println("Deposit of " + currencyFormatter.format(amount) + " successful.");
				}
				break;
			case "2":
				System.out.println();
				System.out.println("Please enter how much you wish to withdraw.");
				amount = input.nextInt();
				if (amount > myAccount.getBalance()) {
					System.out.println();
					System.out.println("Cannot withdraw. That amount is larger than your account balance.");
				} else if (amount < 0) {
					System.out.println();
					System.out.println("Cannot withdraw negative dollar values.");
				} else {
					myAccount.withdraw(amount);
					System.out.println();
					System.out.println("Withdrawal of " + currencyFormatter.format(amount) + " successful.");
				}
				break;
			case "3":
				System.out.println();
				System.out.println("Your balance is " + currencyFormatter.format(myAccount.getBalance()));
				break;
			case "4":
				break;
			default:
				System.out.println();
				System.out.println("Invalid input.  Please make a valid selection.");
				break;
			}

		} while (!choice.equals("4"));

		System.out.println();
		System.out.println("Thank you. Goodbye.");
		input.close();
	}

}
