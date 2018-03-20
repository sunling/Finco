package bank.account;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ACustomer;

public class Savings extends Account implements IAccount {

	private final static double interestRate = 0.03;
	
	public Savings(String accountNo, ACustomer customer) {
		super(accountNo, customer);
	}

	@Override
	public String getAccountType() {
		return "Saving";
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
