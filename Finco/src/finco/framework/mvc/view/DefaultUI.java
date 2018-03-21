package finco.framework.mvc.view;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class DefaultUI extends BaseUI {

    public DefaultUI(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public String getTitle() {
        return "FinCo";
    }

    @Override
    public void configureTableHeader() {
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Amount");
    }
}
