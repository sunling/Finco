package ccard.controller;

import ccard.account.CCAccount;
import ccard.command.AddCCAccount;
import ccard.gui.component.AddCCAccountDialog;
import ccard.model.AccountDTO;
import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.AddInterest;
import finco.framework.factory.TransactionCommandFactory;
import finco.framework.mvc.controller.DefaultController;
import finco.framework.mvc.model.TransactionDTO;
import finco.framework.mvc.view.IMainUI;
import finco.framework.singleton.LocalDataObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class CreditCardController extends DefaultController {

	public CreditCardController(IFinCo finCo, IMainUI ui, DefaultTableModel model) {
		super(finCo, ui, model);
	}

	@Override
	protected void initOperationalButtons() {
		// Add Personal Account
		JButton button = new JButton("Add Credit-card Account");
		button.addActionListener(e -> addCreditCardAccount());
		ui.addOperationalButton(button);

		// Add Interest
//		JButton button3 = new JButton("Add Interest");
//		button3.addActionListener(e -> addInterest());
//		ui.addOperationalButton(button3);

		// Generate a report of accounts
		JButton button4 = new JButton("Generate Monthly bill");
		button4.addActionListener(e -> generateReport());
		ui.addOperationalButton(button4);

	}

	protected void initTransactionalButtons() {

		JButton button = new JButton("Deposit");
		button.addActionListener(e -> deposit());
		ui.addTransactionalButton(button);

		JButton button2 = new JButton("Charge");
		button2.addActionListener(e -> withdraw());
		ui.addTransactionalButton(button2);
	}

	private void addCreditCardAccount() {

		AccountDTO dto = new AccountDTO();
		AddCCAccountDialog dialog = new AddCCAccountDialog(dto);
		dialog.setBounds(450, 20, 300, 380);
		dialog.setVisible(true);

		if (dto.isValid()) {
			finCo.doOperation(new AddCCAccount(dto));
			System.out.println("Add credit-card action performed");
		} else {
			System.out.println("Name, Account number and Email address are mandatory!");
		}

		refreshList();

	}

	private void addInterest() {
		finCo.doTransaction(new AddInterest());
		refreshList();
		System.out.println("Add interest to all of accounts");
	}

    protected void deposit() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.elementAt(1));

            // dialog
            displayTransactionDialog("Deposit", dto);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(TransactionCommandFactory.getInstance("DEPOSIT", dto.getAccountNumber(), dto.getAmount()));

            // update list
            refreshList();
        }

        System.out.println("Deposit action performed in default controller");
    }

    protected void withdraw() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.get(1));

            // dialog
            displayTransactionDialog("Withdraw", dto);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(TransactionCommandFactory.getInstance("WITHDRAW", dto.getAccountNumber(), dto.getAmount()));

            refreshList();
        }

        System.out.println("Withdraw action performed in default controller");
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void refreshList() {
		LocalDataObject db = LocalDataObject.getInstance();
		for (Account acc : db.getAllAccount()) {
			boolean found = false;
			for (Object obj : model.getDataVector()) {
				Vector vec = (Vector) obj;
				if (vec.elementAt(1).equals(acc.getAccountNo())) {
					found = true;
					vec.set(0, acc.getCustomer().getName());
					vec.set(4, acc.getBalance());
				}
			}
			if (!found) {
				// add data to table
				Object[] rowdata = new Object[5];
				rowdata[0] = acc.getCustomer().getName();
				rowdata[1] = acc.getAccountNo();
				rowdata[2] = ((CCAccount)acc).getExpDate();
				rowdata[3] = acc.getAccountType();
				rowdata[4] = acc.getBalance();
				model.addRow(rowdata);
			}
		}
		ui.getFrame().repaint();
    }
}
