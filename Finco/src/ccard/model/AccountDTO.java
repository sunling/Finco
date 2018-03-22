package ccard.model;

import finco.framework.mvc.model.CustomerAccountDTO;

public class AccountDTO extends CustomerAccountDTO {
    private String expDate;

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
