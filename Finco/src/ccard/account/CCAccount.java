package ccard.account;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ACustomer;

public abstract class CCAccount extends Account implements IAccount {
    private String expDate;

    public CCAccount(String accountNo, ACustomer customer) {
        super(accountNo, customer);
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

}
