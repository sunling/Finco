package finco.framework.gui;

import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.*;
import finco.framework.gui.component.AddAccountDialog;
import finco.framework.gui.component.TransactionDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class DefaultController {

    protected IMainUI ui;
    protected IFinCo finCo;
    protected DefaultTableModel model;
    protected AccountFactory accountFactory;

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

        ui.configureCreditTransactionButton("Deposit", e -> deposit());
        ui.configureDebitTransactionButton("Withdraw", e -> withdraw());
    }

    private void addAccount() {

        Account anAccount = accountFactory.createAccount();

        JDialog dialog = new AddAccountDialog(anAccount);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        Operation operation = new AddAccount(anAccount.getCustomer(), anAccount);
        finCo.doOperation(operation);
    }

    private void deposit() {
        // dialog
        Vector<Object> selectedAccount = ui.getSelectedModel();
        String accountNo = (String) selectedAccount.get(0);
        TransactionDialog dialog = new TransactionDialog(accountNo);
        dialog.setTitle("Deposit");
        dialog.setBounds(430, 15, 275, 140);
        dialog.setVisible(true);

        // command
        Transaction transaction = new DepositEntry(accountNo, dialog.getAmount());
        finCo.doTransaction(transaction);
    }

    private void withdraw() {
        // dialog
        Vector<Object> selectedAccount = ui.getSelectedModel();
        String accountNo = (String) selectedAccount.get(0);
        TransactionDialog dialog = new TransactionDialog(accountNo);
        dialog.setTitle("Withdraw");
        dialog.setBounds(430, 15, 275, 140);
        dialog.setVisible(true);

        // command
        Transaction transaction = new WithdrawEntry(accountNo, dialog.getAmount());
        finCo.doTransaction(transaction);
    }
}
