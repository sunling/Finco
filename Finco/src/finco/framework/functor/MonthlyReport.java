package finco.framework.functor;

import java.util.ArrayList;

import finco.framework.account.Account;
import finco.framework.singleton.CustomerLog;
import finco.framework.singleton.LocalDataObject;

/**
* @author Sumit Wankhede
*/

public class MonthlyReport implements Functor<Account, String>{
	
	StringBuilder report = new StringBuilder();
	private ArrayList<CustomerLog> log;
	
	public MonthlyReport(LocalDataObject localDataObject) {
		log = localDataObject.getLog();
    }
	
	@Override
	public void compute(Account account) {
		// TODO Auto-generated method stub
		String newRecord = System.lineSeparator();
		
		report.append("Account : " + account.getAccountNo() + "\t\t Balance : " + account.getBalance());
		report.append("Transaction Type" + "\t\t Ammount" + "\t\t Date");
		for(CustomerLog logEntry : log) {
			
			if(logEntry.getAccount_No() == account.getAccountNo()) {
				report.append(logEntry.getTransaction_Type() + "\t\t" + logEntry.getAmount() + "\t\t" + logEntry.getDate());
				report.append(newRecord);
			}
			
		}
		
        report.append(newRecord);
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return report.toString();
	}

}