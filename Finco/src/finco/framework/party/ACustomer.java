package finco.framework.party;

import java.util.ArrayList;
import java.util.List;

import finco.framework.account.IAccount;
import finco.framework.party.ICustomer;

/**
* @author: Sumit Wankhede
*/

public abstract class ACustomer implements ICustomer{
	
	private String name;
    private String email;
    private String street;
    private String city;
    private String State;
    private String zip;
    private List<IAccount> accounts;

    public void Customer() {
        this.accounts = new ArrayList<>();
    }
	

//    public void sendAlert(Entry entry, Account account);
    
    @Override
    public List<IAccount> getAccounts() {
        return accounts;
    }

    @Override
    public void addAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    @Override
    public abstract String getCustomerType();
    
    public void setAccounts(List<IAccount> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

    
}
