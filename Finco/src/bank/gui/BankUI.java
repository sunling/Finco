package bank.gui;

import finco.framework.mvc.view.BaseUI;

import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class BankUI extends BaseUI {
    public BankUI(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public String getTitle() {
        return "Banking application";
    }

    @Override
    public void configureTableHeader() {

        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");

    }

    protected Dimension getPreferredSizeForOpsBtnsContainer() {
        return new Dimension(575, 90);
    }
}
