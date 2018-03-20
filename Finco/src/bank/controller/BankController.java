package bank.controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bank.account.Checkings;
import bank.account.Savings;
import bank.command.AddCompanyAccount;
import bank.command.AddPersonalAccount;
import bank.gui.component.AddCompanyAccountDialog;
import bank.gui.component.AddPersonalAccountDialog;
import bank.model.CompanyAccount;
import bank.model.PersonalAccount;
import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.*;
import finco.framework.gui.DefaultController;
import finco.framework.gui.IMainUI;
import finco.framework.gui.component.TransactionDialog;
import finco.framework.party.ICustomer;

import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class BankController extends DefaultController {

    public BankController(IFinCo finCo, IMainUI ui, DefaultTableModel model) {
        super(finCo, ui, model);
    }

    @Override
    protected void initOperationalButtons() {
        // Add Personal Account
        JButton button = new JButton("Add Personal Account");
        button.addActionListener(e -> addPersonalAccount());
        ui.addOperationalButton(button);

        // Add Company Account
        JButton button2 = new JButton("Add Company Account");
        button2.addActionListener(e -> addCompanyAccount());
        ui.addOperationalButton(button2);

    }

    protected void initTransactionalButtons() {
        ui.configureCreditTransactionButton("Deposit", e -> deposit());
        ui.configureDebitTransactionButton("Withdraw", e -> withdraw());
    }
    
    private void addPersonalAccount() {

        PersonalAccount dto = new PersonalAccount();
        AddPersonalAccountDialog dialog = new AddPersonalAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid()) {
            finCo.doOperation(new AddPersonalAccount(dto));
        }
	}

	private void addCompanyAccount() {

        CompanyAccount dto = new CompanyAccount();
        AddCompanyAccountDialog dialog = new AddCompanyAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid()) {
            finCo.doOperation(new AddCompanyAccount(dto));
        }
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
