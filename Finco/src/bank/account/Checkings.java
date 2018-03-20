package bank.account;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ACustomer;

public class Checkings extends Account implements IAccount {

	private final static double interestRate = 0.02;
	
	public Checkings(String accountNo, ACustomer customer) {
		super(accountNo, customer);
	}

	@Override
	public String getAccountType() {
		return "Checking";
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
