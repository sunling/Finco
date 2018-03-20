package finco.framework.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import finco.framework.account.Account;
import finco.framework.party.ICustomer;

/**
* @author Sumit Wankhede
*/

public class LocalDataObject {
	
	HashMap<ICustomer, List<Account>> dataObject;
	private static LocalDataObject localDataObject = null;
	private ArrayList<CustomerLog> customerLogList;
	
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
            for (Account account : list) {
                allAccounts.add(account);
            }
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
    
}
