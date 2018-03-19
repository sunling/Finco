package framework.command;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import framework.account.Account;
import framework.account.Entry;
import framework.party.ACustomer;
import framework.singleton.CustomerLog;
import framework.singleton.LocalDataObject;

public class DepositEntry implements Transaction {

	private LocalDataObject db =LocalDataObject.getInstance();
	
	private String accountNo;
	private double amount;
	
	public DepositEntry(String accountNo,double amount) {
		this.accountNo = accountNo;
		this.amount = amount;
	}
	@Override
	public void execute() {
		List<Account> accountlist = db.getAllAccount();
		for (Account account : accountlist) {
			if(accountNo.equals(account.getAccountNo())) {
				//1.update balance
				Calendar calender = Calendar.getInstance();
		        Date date = calender.getTime();
				account.setAmount(account.getBalance()+amount);
				
				//2. add entry
				account.addEntry(amount);
				
				//3.add log
				ACustomer customer = account.getCustomer();
				CustomerLog log = new CustomerLog(customer.getName(),
						accountNo,account.getAccountType(),"DEPOSIT",date,String.valueOf(amount));
				db.addLog(log);
				break;
			}else {
				//not found
			}
		}
	}

}
