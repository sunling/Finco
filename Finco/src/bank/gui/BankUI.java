package bank.gui;

import framework.gui.AMainUI;
import framework.gui.FinCo;

import javax.swing.table.DefaultTableModel;

public class BankUI extends AMainUI {
    public BankUI(FinCo finCo, DefaultTableModel tableModel) {
        super(finCo, tableModel);
    }

    @Override
    public String getTitle() {
        return "Banking application";
    }
}
