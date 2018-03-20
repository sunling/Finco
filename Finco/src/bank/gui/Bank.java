package bank.gui;


import finco.framework.FinCo;
import finco.framework.IFinCo;
import finco.framework.gui.IMainUI;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class Bank {
    public static void main(String[] args) {

        IFinCo finCo = new FinCo();
        DefaultTableModel model = new DefaultTableModel();
        IMainUI ui = new BankUI(model);

        BankController controller = new BankController(finCo, ui, model);

        ui.initialize();
    }
}
