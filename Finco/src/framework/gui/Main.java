package framework.gui;

import javax.swing.table.DefaultTableModel;

public class Main {
    public static void main(String[] args) {

        FinCo finCo = new FinCo();
        DefaultTableModel model = new DefaultTableModel();
        DefaultUI ui = new DefaultUI(finCo, model);
        DefaultController controller = new DefaultController(finCo, ui, model);
        ui.initialize();
    }
}
