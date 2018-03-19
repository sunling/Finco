package framework.command;

public class TransactionManager {
	
	//Transaction transaction;
	public void submitTransaction(Transaction transaction) {
		transaction.execute();
	}

}
