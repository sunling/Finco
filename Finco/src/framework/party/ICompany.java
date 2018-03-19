package finco.framework.party;

import finco.framework.account.Account;;

/**
* @author: Sumit Wankhede
*/
public interface ICompany extends ICustomer{
	public void addAccount(Account account);
    public void removeAccount(Account account);
    public String getCustomerType();
}
