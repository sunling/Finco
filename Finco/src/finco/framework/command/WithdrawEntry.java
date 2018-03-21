package finco.framework.command;

import java.util.Calendar;
import java.util.Date;

import finco.framework.account.Entry;
import finco.framework.account.IAccount;
import finco.framework.singleton.CustomerLog;
import finco.framework.singleton.LocalDataObject;

/**
 * Concrete command: withdraw money
 * @author Ling Sun
 *
 */
public class WithdrawEntry implements Transaction {

	private LocalDataObject db =LocalDataObject.getInstance();
	
	private String accountNo;
	private double amount;
	
	public WithdrawEntry(String accountNo,double amount) {
		this.accountNo = accountNo;
		this.amount = amount;
	}
	@Override
	public void execute() {
		//0. get account
		IAccount account = db.getAccount(accountNo);
		
		//1.check
		if(account.getBalance() - amount < 0) {
			System.out.println("Balance is insufficient");
			return;
		}
		//2. add entry
		Calendar calender = Calendar.getInstance();
        Date date = calender.getTime();
		Entry entry = new Entry(-amount, date, "WITHDRAW");
		account.addEntry(entry);
		
		//3.add log
		CustomerLog log = new CustomerLog(account,entry);
		db.addLog(log);
	}

}
