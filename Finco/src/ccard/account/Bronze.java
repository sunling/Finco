package ccard.account;

import finco.framework.party.ACustomer;

public class Bronze extends CCAccount {

	private final static double interestRate = 0.02;
	public final static double monthlyIntRate = 0.1;
	public final static double minPayment = 0.14;
	
	public Bronze(String accountNo, ACustomer customer) {
		super(accountNo, customer);
	}

	@Override
	public String getAccountType() {
		return "Bronze";
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
