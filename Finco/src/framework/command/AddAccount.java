package framework.command;

import framework.account.Account;
import framework.party.ACustomer;
import framework.singleton.LocalDataObject;

/**
 * concrete command
 * @author Ling Sun
 *
 */
public class AddAccount implements Operation {
	private LocalDataObject db =LocalDataObject.getInstance();
	
	private ACustomer customer ;
	private Account account;
	
	public AddAccount(ACustomer customer,Account account) {
		this.customer = customer;
		this.account = account;
	}
	@Override
	public void execute() {
		//add an account
		db.getAllCustomer().add(customer);
		//add a customer
		db.getAllAccount().add(account);
	}

}
