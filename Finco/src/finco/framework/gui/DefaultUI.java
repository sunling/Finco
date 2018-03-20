package finco.framework.gui;

import javax.swing.table.DefaultTableModel;

public class DefaultUI extends AMainUI {

    public DefaultUI(FinCo finCo, DefaultTableModel tableModel) {
        super(finCo, tableModel);
    }

    @Override
    public String getTitle() {
        return "FinCo";
    }
}
