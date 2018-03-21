package finco.framework.factory;

import finco.framework.command.AddInterest;
import finco.framework.command.DepositEntry;
import finco.framework.command.Transaction;
import finco.framework.command.WithdrawEntry;

/*
 * @Author Sumit Wankhede
 */

public class TransactionCommandFactory {
	public static Transaction getInstance(String transactionType, String accountNo, double amount) {
        switch (transactionType) {
            case "DEPOSIT":
                return new DepositEntry(accountNo, amount);
            case "WITHDRAW":
                return new WithdrawEntry(accountNo, amount);
            case "ADD INTEREST":
                return new AddInterest();
            default:
                return null;
        }
    }
}
