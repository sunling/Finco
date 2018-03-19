package finco.framework.account;

import finco.framework.party.ICustomer;

/**
* @author: Sumit Wankhede
*/
public interface IAccount {

   public void addEntry(double amount);
   public void addInterest();
   public double getBalance();
   public String getAccountType();
   public double getInterest();
   public ICustomer getCustomer();
//   public void notifyCustomer(Entry entry, Account account);
   
}
