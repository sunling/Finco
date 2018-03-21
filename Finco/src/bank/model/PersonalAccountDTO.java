package bank.model;

import finco.framework.mvc.model.CustomerAccountDTO;

public class PersonalAccountDTO extends CustomerAccountDTO {
    private String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
