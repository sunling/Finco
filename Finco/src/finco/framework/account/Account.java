package finco.framework.account;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	public void addEntry(double amount, String transaction_Type) {
		// TODO Auto-generated method stub
		Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
        Entry entry = new Entry(amount, date, transaction_Type);
        this.entryList.add(entry);

        balance += amount;
        
        //notifyToCustomer(entry, this);
	}

	@Override
	public String getAccountType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		double rate = this.getInterest();
        double interest = balance * rate;
        balance = balance + interest;
	}	

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ACustomer getCustomer() {
		// TODO Auto-generated method stub
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
