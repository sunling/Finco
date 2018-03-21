package finco.framework;

import finco.framework.command.Operation;
import finco.framework.command.Transaction;
import finco.framework.mvc.view.IMainUI;
import finco.framework.mvc.controller.DefaultController;
import finco.framework.mvc.view.DefaultUI;
import finco.framework.proxy.AuthFinCo;
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

        finCo = new AuthFinCo(finCo, ui);

        DefaultController controller = new DefaultController(finCo, ui, model);
        ui.initialize();
    }
}
