package bank.gui;

import finco.framework.gui.AMainUI;
import finco.framework.gui.FinCo;

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
