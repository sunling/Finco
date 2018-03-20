package bank.model;

import finco.framework.model.CustomerAccount;

public class PersonalAccount extends CustomerAccount {
    private String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
