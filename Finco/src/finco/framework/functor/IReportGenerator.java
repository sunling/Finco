package finco.framework.functor;

import finco.framework.account.Account;

/**
* @author Sumit Wankhede
*/

public interface IReportGenerator {
	public void generateReport(Account localDataObject, Functor<Account,String> functor);
}
