package framework.command;

import java.util.List;

import framework.account.Account;
import framework.singleton.LocalDataObject;

/**
 * Concrete Command : Add interest to all of accounts in bank
 * @author sunling
 *
 */
public class AddInterest implements Transaction {

	private LocalDataObject db =LocalDataObject.getInstance();
	
	double addInterest =0.0;
	
	public AddInterest(double addInterest) {
		this.addInterest = addInterest;
	}
	
	@Override
	public void execute() {
		List<Account> accountList = db.getAllAccount();
		for (Account account : accountList) {
			double interest = account.getInterest();
			account.setInterest(interest+addInterest);
		}
	}

}
