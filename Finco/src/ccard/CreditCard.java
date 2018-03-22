package ccard;


import ccard.controller.CreditCardController;
import ccard.gui.CreditCardUI;
import finco.framework.FinCo;
import finco.framework.IFinCo;
import finco.framework.mvc.view.IMainUI;

import javax.swing.table.DefaultTableModel;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class CreditCard {
    public static void main(String[] args) {

        IFinCo finCo = new FinCo();

        DefaultTableModel model = new DefaultTableModel();
        IMainUI ui = new CreditCardUI(model);

        new CreditCardController(finCo, ui, model);

        ui.initialize();
    }
}
