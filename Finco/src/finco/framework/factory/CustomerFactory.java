package finco.framework.factory;

import finco.framework.party.ACustomer;
import finco.framework.party.Company;
import finco.framework.party.Person;

/*
 * @Author Sumit Wankhede
 */


public class CustomerFactory {
	public static ACustomer getInstance(String type) {
        switch (type) {
            case "PERSON":
                return new Person();
            case "COMPANY":
                return new Company();
            default:
                return null;
        }
    }
}
