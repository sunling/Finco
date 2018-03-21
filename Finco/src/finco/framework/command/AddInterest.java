package finco.framework.command;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import finco.framework.account.Account;
import finco.framework.account.Entry;
import finco.framework.singleton.CustomerLog;
import finco.framework.singleton.LocalDataObject;

/**
 * Concrete Command : Add interest to all of accounts in bank
 * @author sunling
 *
 */
public class AddInterest implements Transaction {

	private LocalDataObject db =LocalDataObject.getInstance();
	
	@Override
	public void execute() {
		List<Account> accountList = db.getAllAccount();
		for (Account account : accountList) {
			double interest = account.getInterest();
			Calendar calender = Calendar.getInstance();
	        Date date = calender.getTime();
	        
			Entry entry = new Entry(interest, date, "ADD INTEREST");
			account.addEntry(entry);
			
			CustomerLog log = new CustomerLog(account,entry);
			db.addLog(log);
		}
	}

}
