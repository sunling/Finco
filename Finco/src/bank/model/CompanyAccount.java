package bank.model;

import finco.framework.model.CustomerAccount;

public class CompanyAccount extends CustomerAccount {
    private String numOfEmployee;

    public String getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(String numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }
}
