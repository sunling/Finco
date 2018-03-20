package bank.gui;


import finco.framework.gui.FinCo;
import finco.framework.gui.IMainUI;

import javax.swing.table.DefaultTableModel;

public class Bank {
    public static void main(String[] args) {

        FinCo finCo = new FinCo();
        DefaultTableModel model = new DefaultTableModel();
        IMainUI ui = new BankUI(finCo, model);

        BankController controller = new BankController(finCo, ui, model);

        ui.initialize();
    }
}
