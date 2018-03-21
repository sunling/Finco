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
 // private String exp_Date; 
    
    public Account(String accountNo, ACustomer customer) {
        this.account_No = accountNo;
        this.customer = customer;
        this.entryList = new ArrayList<Entry>();
    }
	
	@Override
	public void addEntry(Entry entry) {
        this.entryList.add(entry);
        balance += entry.getAmount();
	}

	@Override
	public abstract String getAccountType();
	

	@Override
	public void addInterest() {
		DecimalFormat fmt = new DecimalFormat("##0.00");
		double interest = balance * this.getInterestRate();
        balance = Double.valueOf(fmt.format(balance + interest));
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

//    public String getExpDate() {
//        return exp_Date;
//    }
//
//    public void setExpDate(String exp_Date) {
//        this.exp_Date = exp_Date;
//    }
	
	
//	@Override
//	public void notifyCustomer(Entry entry, Account account) {
//		// TODO Auto-generated method stub
//		
//	}

}
