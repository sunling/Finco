package bank.model;

import finco.framework.model.CustomerAccountDTO;

public class PersonalAccount extends CustomerAccountDTO {
    private String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
