package finco.framework;

import finco.framework.command.Operation;
import finco.framework.command.OperationManager;
import finco.framework.command.Transaction;
import finco.framework.command.TransactionManager;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class FinCo implements IFinCo {
    private TransactionManager transactionManager;
    private OperationManager operationManager;

    public FinCo() {
        this.transactionManager = new TransactionManager();
        this.operationManager = new OperationManager();
    }

    @Override
    public void doOperation(Operation operation) {
        operationManager.submitTransaction(operation);
    }

    @Override
    public void doTransaction(Transaction transaction) {
        transactionManager.submitTransaction(transaction);
    }
}
