package ccard.account;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ACustomer;

public class Gold extends Account implements IAccount {

	private final static double interestRate = 0.02;
	public final static double monthlyIntRate = 0.06;
	public final static double minPayment = 0.1;
	
	public Gold(String accountNo, ACustomer customer) {
		super(accountNo, customer);
	}

	@Override
	public String getAccountType() {
		return "Gold";
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
