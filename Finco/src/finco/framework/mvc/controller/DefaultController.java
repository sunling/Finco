package finco.framework.mvc.controller;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import finco.framework.IFinCo;
import finco.framework.account.Account;
import finco.framework.command.AddAccount;
import finco.framework.command.DepositEntry;
import finco.framework.command.GenerateReport;
import finco.framework.command.WithdrawEntry;
import finco.framework.factory.AccountFactory;
import finco.framework.factory.CustomerFactory;
import finco.framework.functor.MonthlyReport;
import finco.framework.mvc.model.CustomerAccountDTO;
import finco.framework.mvc.model.TransactionDTO;
import finco.framework.mvc.view.IMainUI;
import finco.framework.mvc.view.component.AddAccountDialog;
import finco.framework.mvc.view.component.ReportDialog;
import finco.framework.mvc.view.component.TransactionDialog;
import finco.framework.singleton.LocalDataObject;

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

        initOperationalButtons();
        initTransactionalButtons();

        accountFactory = new AccountFactory();
    }

    protected void initOperationalButtons() {
        JButton button = new JButton("Add Account");
        button.addActionListener(e -> addAccount());
        ui.addOperationalButton(button);

        JButton button2 = new JButton("Generate report");
        button2.addActionListener(e -> generateReport());
        ui.addOperationalButton(button2);
    }

    protected void initTransactionalButtons() {
        JButton button = new JButton("Deposit");
        button.addActionListener(e -> deposit());
        ui.addTransactionalButton(button);

        JButton button2 = new JButton("Withdraw");
        button2.addActionListener(e -> withdraw());
        ui.addTransactionalButton(button2);
    }

    private void addAccount() {
        CustomerAccountDTO dto = new CustomerAccountDTO();
        AddAccountDialog dialog = new AddAccountDialog(dto);
        dialog.setVisible(true);

        if (dto.isValid())
            finCo.doOperation(new AddAccount(dto));

        refreshList();

        System.out.println("Add account action performed in default controller");
    }

    protected void generateReport() {
        LocalDataObject db = LocalDataObject.getInstance();
        MonthlyReport monthlyReport = new MonthlyReport(db);
        for(Account account: db.getAllAccount()) {
            finCo.doOperation(new GenerateReport(account, monthlyReport));
        }

        ReportDialog dialog = new ReportDialog(monthlyReport.getResult());
        dialog.setVisible(true);

        System.out.println("Generate report action performed");
        System.out.println(monthlyReport.getResult());
    }

    protected void deposit() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.elementAt(0));

            // dialog
            displayTransactionDialog("Deposit", dto);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(new DepositEntry(dto.getAccountNumber(), dto.getAmount()));

            // update list
            refreshList();
        }

        System.out.println("Deposit action performed in default controller");
    }

    protected void withdraw() {
        Vector<Object> selectedAccount = ui.getSelectedModel();
        if (selectedAccount != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setAccountNumber((String) selectedAccount.get(0));

            // dialog
            displayTransactionDialog("Withdraw", dto);

            // command
            if (dto.getAmount() != null)
                finCo.doTransaction(new WithdrawEntry(dto.getAccountNumber(), dto.getAmount()));

            refreshList();
        }

        System.out.println("Withdraw action performed in default controller");
    }

    protected void displayTransactionDialog(String title, TransactionDTO dto) {
        TransactionDialog dialog = new TransactionDialog(dto);
        dialog.setTitle(title);
        dialog.setVisible(true);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected void refreshList() {
        LocalDataObject db = LocalDataObject.getInstance();
        for (Account acc : db.getAllAccount()) {
            boolean found = false;
            for(Object obj: model.getDataVector()) {
            		Vector vec = (Vector)obj;
                if (vec.elementAt(0).equals(acc.getAccountNo())) {
                    found = true;
                    vec.set(1, acc.getCustomer().getName());
                    vec.set(2, acc.getCustomer().getCity());
                    vec.set(3, acc.getBalance());
                }
            }
            if (!found) {
                // add data to table
                Object[] rowdata = new Object[4];
                rowdata[0] = acc.getAccountNo();
                rowdata[1] = acc.getCustomer().getName();
                rowdata[2] = acc.getCustomer().getCity();
                rowdata[3] = acc.getBalance();
                model.addRow(rowdata);
            }
        }
    }
}
