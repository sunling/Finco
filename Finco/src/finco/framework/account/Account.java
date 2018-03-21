package finco.framework.account;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import finco.framework.party.ACustomer;


/**
* @author: Sumit Wankhede
*/

public abstract class Account implements IAccount {
	
	private ACustomer customer;
    private String account_No;
    private double balance;
    private List<Entry> entryList;
    
    public Account(String accountNo, ACustomer customer) {
        this.account_No = accountNo;
        this.customer = customer;
        this.entryList = new ArrayList<Entry>();
    }
	
	@Override
	public void addEntry(Entry entry) {
        this.entryList.add(entry);
        
        DecimalFormat fmt = new DecimalFormat("##0.00");
        balance =Double.valueOf(fmt.format(balance+entry.getAmount())) ;
        
        notifyCustomer(entry, this);
	}

	@Override
	public abstract String getAccountType();
	

	@Override
	public double getInterest() {
		return balance * this.getInterestRate();
	}	

	@Override
	public abstract double getInterestRate();

	@Override
	public ACustomer getCustomer() {
		return customer;
	}
	
	@Override
    public double getBalance() {
        return balance;
    }

	public String getAccountNo() {
        return account_No;
    }

    public void setAccountNo(String account_No) {
        this.account_No = account_No;
    }

    public void setAmount(double amount) {
        balance = amount;
    }
	
	@Override
	public void notifyCustomer(Entry entry, Account account) {
		// TODO Auto-generated method stub
		this.getCustomer().sendAlert(entry, account);
	}

}
