package finco.framework.functor;

import finco.framework.account.Account;

/**
* @author Sumit Wankhede
*/

public class ReportGenerator implements IReportGenerator{

	@Override
	public void generateReport(Account account, Functor<Account, String> functor) {
		// TODO Auto-generated method stub
		functor.compute(account);
    }
}
