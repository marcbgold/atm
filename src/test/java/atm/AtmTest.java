package atm;

import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

	@Test
	public void shouldHaveDefaultBalance() {
		// arrange
		Atm underTest = new Atm();

		// act
		double balance = underTest.getBalance();

		// assert
		Assert.assertEquals(500.00, balance, 0.001);
	}

	@Test
	public void shouldHaveStartingBalance() {
		Atm underTest = new Atm("1234", 1000.00);
		double balance = underTest.getBalance();
		Assert.assertEquals(1000.00, balance, 0.001);
	}

	@Test
	public void shouldWithdraw50() {
		Atm underTest = new Atm();
		underTest.withdraw(50);
		double balance = underTest.getBalance();
		Assert.assertEquals(450.00, balance, 0.001);
	}

	@Test
	public void shouldDeposit50() {
		Atm underTest = new Atm();
		underTest.deposit(50);
		double balance = underTest.getBalance();
		Assert.assertEquals(550.00, balance, 0.001);
	}

	@Test
	public void shouldAllowAccessByPin() {
		Atm underTest = new Atm();
		boolean check = underTest.allowAccess("1234");
		Assert.assertTrue(check);
	}

	@Test
	public void shouldDenyAccessByPin() {
		Atm underTest = new Atm();
		boolean check = underTest.allowAccess("1111");
		Assert.assertFalse(check);
	}

	@Test
	public void shouldPreventOverdraw() {
		Atm underTest = new Atm();
		boolean check = underTest.withdraw(9999);
		Assert.assertFalse(check);
	}

}
