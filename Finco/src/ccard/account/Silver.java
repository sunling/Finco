package ccard.account;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ACustomer;

public class Silver extends Account implements IAccount {

	private final static double interestRate = 0.02;
	public final static double monthlyIntRate = 0.08;
	public final static double minPayment = 0.12;
	
	public Silver(String accountNo, ACustomer customer) {
		super(accountNo, customer);
	}

	@Override
	public String getAccountType() {
		return "Silver";
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
