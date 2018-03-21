package finco.framework.command;

import finco.framework.account.Account;
import finco.framework.factory.CustomerFactory;
import finco.framework.mvc.model.CustomerAccountDTO;
import finco.framework.party.ACustomer;
import finco.framework.singleton.LocalDataObject;

/**
 * concrete command
 * @author Ling Sun
 *
 */
public class AddAccount implements Operation {
	private LocalDataObject db = LocalDataObject.getInstance();

	private CustomerAccountDTO customerAccount;
	protected ACustomer customer;
	protected Account account;

	public AddAccount(CustomerAccountDTO customerAccount) {
	    this.customerAccount = customerAccount;
	}
	@Override
	public void execute() {

        // check existing account
        for(Account acc: db.getAllAccount()) {
            if (acc.getAccountNo().equals(customerAccount.getAccountNo()))
                // account number duplicate
                return;
        }

	    customer = CustomerFactory.getInstance("PERSON");

	    // customerAccount to customer
        customer.setName(customerAccount.getCustomerName());
        customer.setEmail(customerAccount.getEmail());
        customer.setStreet(customerAccount.getStreet());
        customer.setCity(customerAccount.getCity());
        customer.setState(customerAccount.getState());
        customer.setZip(customerAccount.getZip());

	    account = createAccount();
	    if (account == null)
	        System.out.println("why null?");
	    customer.addAccount(account);

		//add an account
        db.addCustomer(customer);
        db.addAccount(account);

	}

    private Account createAccount() {
	    account = new Account(customerAccount.getAccountNo(), customer) {
            @Override
            public String getAccountType() {
                return "DEFAULT";
            }

            @Override
            public double getInterestRate() {
                return 0;
            }
        };
	    return account;
    }
}
