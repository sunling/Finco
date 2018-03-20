package finco.framework.gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public interface IMainUI {
    void addOperationalButton(JButton button);
    void configureCreditTransactionButton(String label, ActionListener actionListener);
    void configureDebitTransactionButton(String label, ActionListener actionListener);
    String getTitle();
    JPanel getJPanel();
    void initialize();
    Vector<Object> getSelectedModel();
}
