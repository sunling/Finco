package framework.command;

public class OperationManager {
	public void submitTransaction(Operation operation) {
		operation.execute();
	}


}
