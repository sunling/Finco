package finco.framework;

import finco.framework.command.Operation;
import finco.framework.command.Transaction;
import finco.framework.gui.IMainUI;
import finco.framework.gui.DefaultController;
import finco.framework.gui.DefaultUI;
import finco.framework.proxy.EmptyProxyFunc;
import finco.framework.proxy.ProxyFinCo;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class Main {
    public static void main(String[] args) {

        // create a FinCo instance
        IFinCo finCo = new FinCo();
        // proxying the finCo
        finCo = new ProxyFinCo(finCo, new EmptyProxyFunc<Operation>(), new EmptyProxyFunc<Transaction>());

        DefaultTableModel model = new DefaultTableModel();
        IMainUI ui = new DefaultUI(model);
        DefaultController controller = new DefaultController(finCo, ui, model);
        ui.initialize();
    }
}
