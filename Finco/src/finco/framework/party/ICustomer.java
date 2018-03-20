package finco.framework.party;

import java.util.List;
import finco.framework.account.IAccount;

/**
 * @author: Sumit Wankhede
 */

public interface ICustomer {
    public void addAccount(IAccount account);
    public void removeAccount(IAccount account);
    public String getCustomerType();
    public List<IAccount> getAccounts();
//    public void sendAlert(Entry entry, Account account);
}
