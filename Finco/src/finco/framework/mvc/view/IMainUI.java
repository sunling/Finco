package finco.framework.mvc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public interface IMainUI {
    String getTitle();
    void addOperationalButton(JButton button);
    void addTransactionalButton(JButton button);
    void configureTableHeader();

    Vector<Object> getSelectedModel();
    JFrame getFrame();

//    void configureCreditTransactionButton(String label, ActionListener actionListener);
//    void configureDebitTransactionButton(String label, ActionListener actionListener);
    void initialize();
}
