package bank.gui;

import finco.framework.gui.Command;
import finco.framework.gui.DefaultController;
import finco.framework.gui.FinCo;
import finco.framework.gui.IMainUI;

import javax.swing.table.DefaultTableModel;

public class BankController extends DefaultController {

    public BankController(FinCo finCo, IMainUI ui, DefaultTableModel model) {
        super(finCo, ui, model);
    }

    @Override
    protected void initOperationalButtons() {

        ui.addOperationalButton("Add Personal Account", new Command() {
            @Override
            public void execute() {
                System.out.println("Add Personal Account");
            }
        });

        ui.addOperationalButton("Add Company Account", new Command() {
            @Override
            public void execute() {
                System.out.println("Add Company Account");
            }
        });

    }

    protected void initTransactionalButtons() {
        ui.configureCreditTransactionButton("Deposit", new Command() {
            @Override
            public void execute() {
                System.out.println("Deposit");
            }
        });
        ui.configureDebitTransactionButton("Withdraw", new Command() {
            @Override
            public void execute() {
                System.out.println("Withdraw");
            }
        });
    }
}
