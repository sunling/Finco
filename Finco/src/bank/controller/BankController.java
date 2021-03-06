package bank.controller;

import bank.command.AddCompanyAccount;
import bank.command.AddPersonalAccount;
import bank.gui.component.AddCompanyAccountDialog;
import bank.gui.component.AddPersonalAccountDialog;
import bank.model.CompanyAccountDTO;
import bank.model.PersonalAccountDTO;
import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.AddInterest;
import finco.framework.mvc.controller.DefaultController;
import finco.framework.mvc.view.IMainUI;
import finco.framework.singleton.LocalDataObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

		// Add Interest
		JButton button3 = new JButton("Add Interest");
		button3.addActionListener(e -> addInterest());
		ui.addOperationalButton(button3);

		// Generate a report of accounts
		JButton button4 = new JButton("Generate Report");
		button4.addActionListener(e -> generateReport());
		ui.addOperationalButton(button4);

	}

	protected void initTransactionalButtons() {
		super.initTransactionalButtons(); // same as framework
	}

	private void addPersonalAccount() {

		PersonalAccountDTO dto = new PersonalAccountDTO();
		AddPersonalAccountDialog dialog = new AddPersonalAccountDialog(dto);
		dialog.setBounds(450, 20, 300, 330);
		dialog.setVisible(true);

		if (dto.isValid()) {
			finCo.doOperation(new AddPersonalAccount(dto));
			System.out.println("Add personal account action performed");
		} else {
			System.out.println("Name, Account number and Email address are mandatory!");
		}

		refreshList();

	}

	private void addCompanyAccount() {

		CompanyAccountDTO dto = new CompanyAccountDTO();
		AddCompanyAccountDialog dialog = new AddCompanyAccountDialog(dto);
		dialog.setBounds(450, 20, 300, 330);
		dialog.setVisible(true);

		if (dto.isValid()) {
            finCo.doOperation(new AddCompanyAccount(dto));
            System.out.println("Add account action performed in default controller");
        }
        else {
        		System.out.println("Name, Account number and Email address are mandatory!");
        }

		refreshList();
	}

	private void addInterest() {
		finCo.doTransaction(new AddInterest());
		refreshList();
		System.out.println("Add interest to all of accounts");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void refreshList() {
		LocalDataObject db = LocalDataObject.getInstance();
		for (Account acc : db.getAllAccount()) {
			boolean found = false;
			for (Object obj : model.getDataVector()) {
				Vector vec = (Vector) obj;
				if (vec.elementAt(0).equals(acc.getAccountNo())) {
					found = true;
					vec.set(1, acc.getCustomer().getName());
					vec.set(2, acc.getCustomer().getCity());
					vec.set(5, acc.getBalance());
				}
			}
			if (!found) {
				// add data to table
				Object[] rowdata = new Object[6];
				rowdata[0] = acc.getAccountNo();
				rowdata[1] = acc.getCustomer().getName();
				rowdata[2] = acc.getCustomer().getCity();
				rowdata[3] = acc.getCustomer().getCustomerType();
				rowdata[4] = acc.getAccountType();
				rowdata[5] = acc.getBalance();
				model.addRow(rowdata);
			}
		}
		ui.getFrame().repaint();
    }
}
