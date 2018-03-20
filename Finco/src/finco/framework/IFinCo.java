package finco.framework;

import finco.framework.command.Operation;
import finco.framework.command.Transaction;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public interface IFinCo {
    void doOperation(Operation operation);
    void doTransaction(Transaction transaction);
}
