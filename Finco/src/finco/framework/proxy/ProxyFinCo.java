package finco.framework.proxy;

import finco.framework.command.Operation;
import finco.framework.command.Transaction;
import finco.framework.IFinCo;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class ProxyFinCo implements IFinCo {

    private IFinCo target;
    private ProxyFunctor<Operation> operationFunc;
    private ProxyFunctor<Transaction> transactionFunc;

    public ProxyFinCo(IFinCo target, ProxyFunctor<Operation> operationFunc, ProxyFunctor<Transaction> transactionFunc) {
        this.target = target;
        this.operationFunc = operationFunc;
        this.transactionFunc = transactionFunc;
    }

    @Override
    public void doOperation(Operation operation) {
        operationFunc.pre(operation);
        target.doOperation(operation);
        operationFunc.post(operation);
    }

    @Override
    public void doTransaction(Transaction transaction) {
        transactionFunc.pre(transaction);
        target.doTransaction(transaction);
        transactionFunc.post(transaction);
    }
}
