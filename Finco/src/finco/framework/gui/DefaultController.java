package finco.framework.gui;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.AddAccount;
import finco.framework.command.Operation;
import finco.framework.gui.component.AddAccountDialog;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class DefaultController {

    protected IMainUI ui;
    protected IFinCo finCo;
    protected DefaultTableModel model;
    protected AccountFactory accountFactory;
    protected TransactionCommandFactor transactionCommandFactor;

    public DefaultController(IFinCo finCo, IMainUI ui, DefaultTableModel model) {
        this.finCo = finCo;
        this.ui = ui;
        this.model = model;

        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Amount");

        initOperationalButtons();
        initTransactionalButtons();

        accountFactory = new AccountFactory();
    }

    protected void initOperationalButtons() {
        JButton button = new JButton();
        button.addActionListener(e -> addAccount());
        ui.addOperationalButton(button);
    }

    protected void initTransactionalButtons() {

        ui.configureCreditTransactionButton("Deposit", transactionCommandFactor.createCommand("deposit"));
        ui.configureDebitTransactionButton("Withdraw", transactionCommandFactor.createCommand("withdraw"));
    }

    private void addAccount() {

        Account anAccount = accountFactory.createAccount();

        AddAccountDialog pac = new AddAccountDialog(anAccount);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        Operation operation = new AddAccount(anAccount.getCustomer(), anAccount);
        finCo.doOperation(operation);
    }
}
