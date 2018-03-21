package bank.controller;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import bank.command.AddCompanyAccount;
import bank.command.AddPersonalAccount;
import bank.gui.component.AddCompanyAccountDialog;
import bank.gui.component.AddInterestDialog;
import bank.gui.component.AddPersonalAccountDialog;
import bank.model.CompanyAccount;
import bank.model.PersonalAccount;
import finco.framework.IFinCo;
import finco.framework.command.AddInterest;
import finco.framework.mvc.controller.DefaultController;
import finco.framework.mvc.view.IMainUI;

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

        // Add Interest
        JButton button3 = new JButton("Add Interest");
        button3.addActionListener(e -> addInterest());
        ui.addOperationalButton(button3);
        
        // Add Company Account
        JButton button2 = new JButton("Add Company1 Account");
        button2.addActionListener(e -> addCompanyAccount());
        ui.addOperationalButton(button2);
        
    }

    protected void initTransactionalButtons() {
//        ui.configureCreditTransactionButton("Deposit", e -> deposit());
//        ui.configureDebitTransactionButton("Withdraw", e -> withdraw());
    }
    
    private void addPersonalAccount() {

        PersonalAccount dto = new PersonalAccount();
        AddPersonalAccountDialog dialog = new AddPersonalAccountDialog(dto);
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dto.isValid()) {
            finCo.doOperation(new AddPersonalAccount(dto));
        }

        refreshList();

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

        refreshList();

        System.out.println("Add company account action performed");
    }
	
	private void addInterest() {
        AddInterestDialog dialog = new AddInterestDialog();
        dialog.setBounds(450, 20, 300, 330);
        dialog.setVisible(true);

        if (dialog.getAddInterest() >0) {
            finCo.doTransaction(new AddInterest(dialog.getAddInterest()));
        }
        

        //refresh list
        System.out.println("Add interest to all of accounts");
    }
}
