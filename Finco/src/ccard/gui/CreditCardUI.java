package ccard.gui;

import finco.framework.mvc.view.BaseUI;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class CreditCardUI extends BaseUI {
    public CreditCardUI(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public String getTitle() {
        return "Credit card application";
    }

    @Override
    public void configureTableHeader() {

        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");

    }

    protected Dimension getPreferredSizeForOpsBtnsContainer() {
        return new Dimension(575, 45);
    }
}
