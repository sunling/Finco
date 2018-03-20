package finco.framework.party;

import finco.framework.account.IAccount;

/**
* @author: Sumit Wankhede
*/
public interface IPerson extends ICustomer{
	public void addAccount(IAccount account);
    public void removeAccount(IAccount account);
    public String getCustomerType();
}
