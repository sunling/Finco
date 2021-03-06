package finco.framework.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import finco.framework.account.Account;
import finco.framework.account.IAccount;
import finco.framework.party.ICustomer;

/**
* @author Sumit Wankhede
*/

public class LocalDataObject {
	
	Map<ICustomer, List<Account>> dataObject = new HashMap<>();
	private static LocalDataObject localDataObject = null;
	private ArrayList<CustomerLog> customerLogList = new ArrayList<>();
	
	private LocalDataObject() {
	}
	

	public static LocalDataObject getInstance() {
        if (localDataObject == null) {
        	localDataObject = new LocalDataObject();
        }
        return localDataObject;
    }
	
	public List<ICustomer> getAllCustomer() {
        return new ArrayList<ICustomer>(dataObject.keySet());
    }

    public List<Account> getAllAccount() {
        List<Account> allAccounts = new ArrayList<>();
        for (List<Account> list : dataObject.values()) {
            allAccounts.addAll(list);
        }
        return allAccounts;
    }

    public void addAccount(Account account) {
        ICustomer iCustomer = account.getCustomer();
        if (dataObject.get(iCustomer) != null) {
        		dataObject.get(iCustomer).add(account);
        } else {
            List<Account> iAccounts = new ArrayList<>();
            iAccounts.add(account);
            dataObject.put(iCustomer, iAccounts);
        }
    }
    
    public void addCustomer(ICustomer customer) {
            dataObject.put(customer, null);
    }
	
    public void addLog(CustomerLog customerlog) {
    		customerLogList.add(customerlog);
    }
    
    public ArrayList<CustomerLog> getLog(){
    		return customerLogList;
    }

	public IAccount getAccount(String accountNo) {
		List<Account> allAccounts = this.getAllAccount();
		for (Account account : allAccounts) {
			if(account.getAccountNo().equals(accountNo)) {
				return account;
			}
		}
		return null;
	}
    
}
