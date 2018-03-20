package bank.gui;

import finco.framework.gui.AMainUI;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class BankUI extends AMainUI {
    public BankUI(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public String getTitle() {
        return "Banking application";
    }
}
