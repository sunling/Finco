package bank.model;

import finco.framework.mvc.model.CustomerAccountDTO;

public class CompanyAccount extends CustomerAccountDTO {
    private String numOfEmployee;

    public String getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(String numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }
}
