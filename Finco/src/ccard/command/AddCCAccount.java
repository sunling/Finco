package ccard.command;

import ccard.account.Bronze;
import ccard.account.CCAccount;
import ccard.account.Gold;
import ccard.account.Silver;
import ccard.model.AccountDTO;
import finco.framework.account.Account;
import finco.framework.command.Operation;
import finco.framework.party.Person;
import finco.framework.singleton.LocalDataObject;

import java.util.Date;

public class AddCCAccount implements Operation {
    private LocalDataObject db = LocalDataObject.getInstance();

    private AccountDTO accountDTO;
    private Person customer;
    protected CCAccount account;

    public AddCCAccount(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    @Override
    public void execute() {

        // check existing account
        for (Account acc : db.getAllAccount()) {
            if (acc.getAccountNo().equals(accountDTO.getAccountNo()))
                // account number duplicate
                return;
        }

        // TODO: use factory
        customer = new Person();

        // customerAccount to customer
        customer.setName(accountDTO.getCustomerName());
        customer.setEmail(accountDTO.getEmail());
        customer.setStreet(accountDTO.getStreet());
        customer.setCity(accountDTO.getCity());
        customer.setState(accountDTO.getState());
        customer.setZip(accountDTO.getZip());
        Date bday = new Date();
        // TODO: convert string date to Date object
        customer.setDateOfBirth(bday);

        account = createAccount();
        account.setExpDate(accountDTO.getExpDate());
        customer.addAccount(account);

        db.addCustomer(customer);
        db.addAccount(account);
    }

    private CCAccount createAccount() {
        if ("Gold".equals(accountDTO.getAccountType())) {
            return new Gold(accountDTO.getAccountNo(), customer);
        } else if ("Silver".equals(accountDTO.getAccountType())) {
            return new Silver(accountDTO.getAccountNo(), customer);
        } else {
            return new Bronze(accountDTO.getAccountNo(), customer);
        }
    }
}
