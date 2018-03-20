package finco.framework.command;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import finco.framework.account.Account;
import finco.framework.party.ACustomer;
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
		List<Account> accountlist = db.getAllAccount();
		for (Account account : accountlist) {
			if(accountNo.equals(account.getAccountNo())) {
				//1.update balance
				Calendar calender = Calendar.getInstance();
		        Date date = calender.getTime();
				account.setAmount(account.getBalance()-amount);
				
				//2. add entry In entry class we can add tnx type
				account.addEntry(amount);
				
				//3.add log Here we can use entry to init Customer log
				ACustomer customer = account.getCustomer();
				CustomerLog log = new CustomerLog(customer.getName(),
						accountNo,account.getAccountType(),"WITHdDRAW",date,String.valueOf(amount));
				db.addLog(log);
				break;
			}else {
				//not found
			}
		}
	}

}
