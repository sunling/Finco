package finco.framework.party;

import finco.framework.account.Account;
import finco.framework.account.Entry;

/**
* @author: Sumit Wankhede
*/

public class Company extends ACustomer implements ICustomer{

	private int no_Of_Employees;
	private String customerType = "Company";

	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return customerType;
	}
	
    public int getNoOfEmployees() {
        return no_Of_Employees;
    }

    public void setNoOfEmployees(int no_Of_Employees) {
        this.no_Of_Employees = no_Of_Employees;
    }
    
	@Override
	public void sendAlert(Entry entry, Account account) {
		// TODO Auto-generated method stub
		System.out.println("Email notification sent to: " + this.getEmail());
	}

}
