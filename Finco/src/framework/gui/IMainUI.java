package framework.gui;

import javax.swing.*;
import java.util.Vector;

public interface IMainUI {
    void addOperationalButton(String label, Command cmd);
    void configureCreditTransactionButton(String label, Command cmd);
    void configureDebitTransactionButton(String label, Command cmd);
    String getTitle();
    JPanel getJPanel();
    void initialize();
    Vector<Object> getSelectedModel();
}
