package finco.framework.command;

import finco.framework.account.Account;
import finco.framework.functor.Functor;
import finco.framework.functor.ReportGenerator;

/**
 * Concrete Command: Generate monthly report
 * @author Ling Sun
 *
 */
public class GenerateReport implements Operation {

	private Account account;
	private ReportGenerator reportGenerator;
	private Functor<Account, String> functor;
	
	public GenerateReport(Account account, Functor<Account, String> functor) {
		this.reportGenerator = ReportGenerator.getInstance();
		this.account = account;
		this.functor = functor;
	}
	@Override
	public void execute() {
		reportGenerator.generateReport(account, functor);
	}

}
