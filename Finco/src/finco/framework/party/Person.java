package finco.framework.party;

import java.util.Date;

import finco.framework.account.Account;
import finco.framework.account.Entry;

/**
* @author: Sumit Wankhede
*/

public class Person extends ACustomer implements IPerson{

	private Date date_Of_Birth;
	private String customerType = "Person";

    public Date getDateOfBirth() {
        return date_Of_Birth;
    }

    public void setDateOfBirth(Date date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }
	
	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return customerType;
	}

	@Override
	public void sendAlert(Entry entry, Account account) {
		// TODO Auto-generated method stub
		System.out.println("Email notification sent to: " + this.getEmail());
	}

	
}
