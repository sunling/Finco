package finco.framework.account;

import finco.framework.party.ACustomer;

/**
* @author: Sumit Wankhede
*/
public interface IAccount {

   public void addEntry(Entry entry);
   public void addInterest();
   public double getBalance();
   public String getAccountType();
   public double getInterest();
   public ACustomer getCustomer();
   public String getAccountNo();
//   public void notifyCustomer(Entry entry, Account account);
   
}
