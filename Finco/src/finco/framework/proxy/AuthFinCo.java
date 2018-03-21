package finco.framework.proxy;

import finco.framework.IFinCo;
import finco.framework.command.Operation;
import finco.framework.command.Transaction;
import finco.framework.mvc.view.IMainUI;
import finco.framework.mvc.view.component.CaptchaDialog;

import javax.swing.*;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class AuthFinCo implements IFinCo {

    private IFinCo target;
    private IMainUI ui;
    public boolean valid = false;

    public AuthFinCo(IFinCo target, IMainUI ui) {
        this.target = target;
        this.ui = ui;
    }

    @Override
    public void doOperation(Operation operation) {

//        valid = false;
//        CaptchaDialog dialog = new CaptchaDialog(ui.getFrame(), this);
//        dialog.setVisible(true);

//        System.out.println("Checking Authorization");

//        if (valid) {
//            System.out.println("Authorization granted");
            target.doOperation(operation);
//        } else {
//            JOptionPane.showMessageDialog(null, "Validation code is incorrect");
//        }
    }

    @Override
    public void doTransaction(Transaction transaction) {

        valid = false;
        CaptchaDialog dialog = new CaptchaDialog(ui.getFrame(), this);
        dialog.setVisible(true);

        if (valid) {
            target.doTransaction(transaction);
        } else {
            JOptionPane.showMessageDialog(null, "Validation code is incorrect");
        }
    }
}
