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

        // add data to table
        Object[] rowdata = new Object[4];
        rowdata[0] = dto.getAccountNo();
        rowdata[1] = dto.getCustomerName();
        rowdata[2] = dto.getCity();
        rowdata[3] = 0;
        model.addRow(rowdata);

        System.out.println("Add personal account action performed");
	}

	private void addCompanyAccount() {

        CompanyAccount dto = new CompanyAccount();
        AddCompanyAccountDialog dialog = new AddCompanyAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid()) {
            finCo.doOperation(new AddCompanyAccount(dto));
        }

        // add data to table
        Object[] rowdata = new Object[4];
        rowdata[0] = dto.getAccountNo();
        rowdata[1] = dto.getCustomerName();
        rowdata[2] = dto.getCity();
        rowdata[3] = 0;
        model.addRow(rowdata);

        System.out.println("Add company account action performed");
    }
}
