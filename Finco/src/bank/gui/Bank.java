package bank.gui;


import javax.swing.table.DefaultTableModel;

import bank.controller.BankController;
import finco.framework.FinCo;
import finco.framework.IFinCo;
import finco.framework.mvc.view.IMainUI;

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
