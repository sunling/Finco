package bank.command;

import bank.account.Checkings;
import bank.account.Savings;
import bank.model.PersonalAccountDTO;
import finco.framework.account.Account;
import finco.framework.command.Operation;
import finco.framework.party.Person;
import finco.framework.singleton.LocalDataObject;

import java.util.Date;

public class AddPersonalAccount implements Operation {
    private LocalDataObject db =LocalDataObject.getInstance();

    private PersonalAccountDTO personalAccountDTO;
    private Person customer ;
    protected Account account;

    public AddPersonalAccount(PersonalAccountDTO personalAccountDTO) {
        this.personalAccountDTO = personalAccountDTO;
    }

    @Override
    public void execute() {

        // check existing account
        for(Account acc: db.getAllAccount()) {
            if (acc.getAccountNo().equals(personalAccountDTO.getAccountNo()))
                // account number duplicate
                return;
        }

        // TODO: use factory
        customer = new Person();

        // customerAccount to customer
        customer.setName(personalAccountDTO.getCustomerName());
        customer.setEmail(personalAccountDTO.getEmail());
        customer.setStreet(personalAccountDTO.getStreet());
        customer.setCity(personalAccountDTO.getCity());
        customer.setState(personalAccountDTO.getState());
        customer.setZip(personalAccountDTO.getZip());
        Date bday = new Date();
        // TODO: convert string date to Date object
        customer.setDateOfBirth(bday);

        account = createAccount();
        customer.addAccount(account);

        db.addCustomer(customer);
        db.addAccount(account);
    }

    private Account createAccount() {
        if ("Savings".equals(personalAccountDTO.getAccountType())) {
            return new Savings(personalAccountDTO.getAccountNo(), customer);
        } else {
            return new Checkings(personalAccountDTO.getAccountNo(), customer);
        }
    }
}
