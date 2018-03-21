package finco.framework.command;

import java.util.Calendar;
import java.util.Date;

import finco.framework.account.Entry;
import finco.framework.account.IAccount;
import finco.framework.singleton.CustomerLog;
import finco.framework.singleton.LocalDataObject;

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
		//check
		if(amount < 0) {
			return ;
		}
		//0. get account
		IAccount account = db.getAccount(accountNo);
		
		//1. add entry
		Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
		Entry entry = new Entry(amount, date, "DEPOSIT");
		account.addEntry(entry);
		
		//2.add log
		CustomerLog log = new CustomerLog(account,entry);
		db.addLog(log);
	}

}
