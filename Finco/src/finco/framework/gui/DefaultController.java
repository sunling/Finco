package finco.framework.gui;

import finco.framework.IFinCo;
import finco.framework.command.AddAccount;
import finco.framework.factory.AccountFactory;
import finco.framework.factory.CustomerFactory;
import finco.framework.gui.component.AddAccountDialog;
import finco.framework.model.CustomerAccount;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class DefaultController {

    protected IMainUI ui;
    protected IFinCo finCo;
    protected DefaultTableModel model;
    protected CustomerFactory customerFactory;
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
        JButton button = new JButton("Add Account");
        button.addActionListener(e -> addAccount());
        ui.addOperationalButton(button);
    }

    protected void initTransactionalButtons() {
        ui.configureCreditTransactionButton("Deposit", e -> deposit());
        ui.configureDebitTransactionButton("Withdraw", e -> withdraw());
    }

    private void addAccount() {
        CustomerAccount dto = new CustomerAccount();
        AddAccountDialog dialog = new AddAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid())
            finCo.doOperation(new AddAccount(dto));

        System.out.println("Add account action performed in default controller");
    }

    private void deposit() {
        System.out.println("Deposit action performed in default controller");
    }

    private void withdraw() {
        System.out.println("Withdraw action performed in default controller");
    }
}
