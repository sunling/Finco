package bank.command;

import bank.account.Checkings;
import bank.account.Savings;
import bank.model.PersonalAccount;
import finco.framework.account.Account;
import finco.framework.command.Operation;
import finco.framework.party.Person;
import finco.framework.singleton.LocalDataObject;

import java.util.Date;

public class AddPersonalAccount implements Operation {
    private LocalDataObject db =LocalDataObject.getInstance();

    private PersonalAccount personalAccount;
    private Person customer ;
    protected Account account;

    public AddPersonalAccount(PersonalAccount personalAccount) {
        this.personalAccount = personalAccount;
    }

    @Override
    public void execute() {

        // check existing account
        for(Account acc: db.getAllAccount()) {
            if (acc.getAccountNo().equals(personalAccount.getAccountNo()))
                // account number duplicate
                return;
        }

        // TODO: use factory
        customer = new Person();

        // customerAccount to customer
        customer.setName(personalAccount.getCustomerName());
        customer.setEmail(personalAccount.getEmail());
        customer.setStreet(personalAccount.getStreet());
        customer.setCity(personalAccount.getCity());
        customer.setState(personalAccount.getState());
        customer.setZip(personalAccount.getZip());
        Date bday = new Date();
        // TODO: convert string date to Date object
        customer.setDateOfBirth(bday);

        account = createAccount();
        customer.addAccount(account);

        db.addCustomer(customer);
        db.addAccount(account);
    }

    private Account createAccount() {
        if ("Savings".equals(personalAccount.getAccountType())) {
            return new Savings(personalAccount.getAccountNo(), customer);
        } else {
            return new Checkings(personalAccount.getAccountNo(), customer);
        }
    }
}
