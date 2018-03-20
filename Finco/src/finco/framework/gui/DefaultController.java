package finco.framework.gui;

import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.AddAccount;
import finco.framework.command.DepositEntry;
import finco.framework.command.WithdrawEntry;
import finco.framework.factory.AccountFactory;
import finco.framework.factory.CustomerFactory;
import finco.framework.gui.component.AddAccountDialog;
import finco.framework.gui.component.TransactionDialog;
import finco.framework.model.CustomerAccountDTO;
import finco.framework.model.TransactionDTO;
import finco.framework.singleton.LocalDataObject;

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
        CustomerAccountDTO dto = new CustomerAccountDTO();
        AddAccountDialog dialog = new AddAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid())
            finCo.doOperation(new AddAccount(dto));

        // add data to table
        Object[] rowdata = new Object[4];
        rowdata[0] = dto.getAccountNo();
        rowdata[1] = dto.getCustomerName();
        rowdata[2] = dto.getCity();
        rowdata[3] = 0;
        model.addRow(rowdata);

        System.out.println("Add account action performed in default controller");
    }

    protected void deposit() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.elementAt(0));

            // dialog
            TransactionDialog dialog = new TransactionDialog(dto);
            dialog.setTitle("Deposit");
            dialog.setVisible(true);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(new DepositEntry(dto.getAccountNumber(), dto.getAmount()));

            // update list
            for(Vector<Object> o: model.getDataVector()) {
                if (dto.getAccountNumber().equals((String)o.elementAt(0))) {
                    LocalDataObject db = LocalDataObject.getInstance();
                    for(Account a: db.getAllAccount())
                        if (a.getAccountNo().equals(dto.getAccountNumber())) {
                            o.set(3, a.getBalance());
                            break;
                        }
                    break;
                }
            }
        }

        System.out.println("Deposit action performed in default controller");
    }

    protected void withdraw() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.get(0));

            // dialog
            TransactionDialog dialog = new TransactionDialog(dto);
            dialog.setTitle("Withdraw");
            dialog.setVisible(true);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(new WithdrawEntry(dto.getAccountNumber(), dto.getAmount()));


            // update list
            for(Vector<Object> o: model.getDataVector()) {
                if (dto.getAccountNumber().equals((String)o.elementAt(0))) {
                    LocalDataObject db = LocalDataObject.getInstance();
                    for(Account a: db.getAllAccount())
                        if (a.getAccountNo().equals(dto.getAccountNumber())) {
                            o.set(3, a.getBalance());
                            break;
                        }
                    break;
                }
            }
        }

        System.out.println("Withdraw action performed in default controller");
    }
}
