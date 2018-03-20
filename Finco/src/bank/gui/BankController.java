package bank.gui;

import finco.framework.IFinCo;
import finco.framework.command.Operation;
import finco.framework.command.Transaction;
import finco.framework.gui.DefaultController;
import finco.framework.gui.IMainUI;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class BankController extends DefaultController {

    public BankController(IFinCo finCo, IMainUI ui, DefaultTableModel model) {
        super(finCo, ui, model);
    }

    @Override
    protected void initOperationalButtons() {

        ui.addOperationalButton("Add Personal Account", new Operation() {
            @Override
            public void execute() {
                System.out.println("Add Personal Account");
            }
        });

        ui.addOperationalButton("Add Company Account", new Operation() {
            @Override
            public void execute() {
                System.out.println("Add Company Account");
            }
        });

    }

    protected void initTransactionalButtons() {
        ui.configureCreditTransactionButton("Deposit", new Transaction() {
            @Override
            public void execute() {
                System.out.println("Deposit");
            }
        });
        ui.configureDebitTransactionButton("Withdraw", new Transaction() {
            @Override
            public void execute() {
                System.out.println("Withdraw");
            }
        });
    }
}
