package finco.framework.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public abstract class AMainUI implements IMainUI {

    protected DefaultTableModel model;


    private JFrame jFrame;

    protected JPanel JPanel1 = new JPanel();
    protected JPanel JPanel2 = new JPanel();
    protected JPanel JPanel3 = new JPanel();
    protected JPanel JPanel4 = new JPanel();

    private JButton JButton_CreditTransaction = new JButton();
    private JButton JButton_DebitTransaction = new JButton();
    private JButton JButton_Exit = new JButton();

    protected JScrollPane JScrollPane1;
    protected JTable JTable1;

    public AMainUI(DefaultTableModel tableModel) {
        this.model = tableModel;

        jFrame = new JFrame();
        jFrame.setTitle(getTitle());
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        BorderLayout bl = new BorderLayout(0,0);
        bl.setVgap(0);
        jFrame.getContentPane().setLayout(bl);
        jFrame.setSize(new Dimension(575, 310));
        jFrame.setVisible(false);

        JPanel1.setPreferredSize(new Dimension(575, 310));
        jFrame.getContentPane().add(BorderLayout.CENTER, JPanel1);

        JPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JPanel2.setPreferredSize(new Dimension(575, 45));
        jFrame.getContentPane().add(BorderLayout.PAGE_START, JPanel2);


        JScrollPane1 = new JScrollPane();
        JTable1 = new JTable(model);

        JPanel1.add(JScrollPane1);
        JScrollPane1.setPreferredSize(new Dimension(444, 200));
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        JPanel1.add(JPanel3);

        JPanel3.setLayout(new BoxLayout(JPanel3, BoxLayout.PAGE_AXIS));
        JButton_CreditTransaction.setText("deposit");
        JPanel3.add(JButton_CreditTransaction);
        JButton_CreditTransaction.setMinimumSize(new Dimension(96, 33));
        JButton_CreditTransaction.setMaximumSize(new Dimension(96, 33));
        JButton_CreditTransaction.setPreferredSize(new Dimension(96, 33));
        JButton_DebitTransaction.setText("withdraw");
        JPanel3.add(JButton_DebitTransaction);
        JButton_DebitTransaction.setMinimumSize(new Dimension(96, 33));
        JButton_DebitTransaction.setMaximumSize(new Dimension(96, 33));
        JButton_DebitTransaction.setPreferredSize(new Dimension(96, 33));

        JPanel4.setLayout(new BorderLayout());
        jFrame.getContentPane().add(BorderLayout.PAGE_END, JPanel4);

        JButton_Exit.setText("Exit");
        JPanel4.add(BorderLayout.LINE_END, JButton_Exit);
        JButton_Exit.setPreferredSize(new Dimension(96, 31));
        JButton_Exit.setMaximumSize(new Dimension(96, 31));
        JButton_Exit.setMinimumSize(new Dimension(96, 31));
        JButton_Exit.addActionListener(e->System.exit(0));



        jFrame.addWindowListener(getWindowListener());
    }

    @SuppressWarnings("unchecked")
	@Override
    public Vector<Object> getSelectedModel() {
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0)
            return (Vector<Object>) model.getDataVector().elementAt(selection);
        return null;
    }

    @Override
    public void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignore) {}
        jFrame.setVisible(true);
    }

    public void addOperationalButton(JButton button) {
        button.setPreferredSize(new Dimension(192, 33));
        JPanel2.add(button);
    }

    @Override
    public void configureCreditTransactionButton(final String label, final ActionListener actionListener) {
        JButton_CreditTransaction.setText(label);
        JButton_CreditTransaction.addActionListener(actionListener);
    }
    @Override
    public void configureDebitTransactionButton(final String label, final ActionListener actionListener) {
        JButton_DebitTransaction.setText(label);
        JButton_DebitTransaction.addActionListener(actionListener);
    }

    @Override
    public JPanel getJPanel() {
        return JPanel1;
    }

    protected WindowListener getWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Object object = e.getSource();
                if (object == jFrame) {
                    try {
                        jFrame.setVisible(false);    // hide the Frame
                        jFrame.dispose();            // free the system resources
                        System.exit(0);            // close the application
                    } catch (Exception ignore) {
                    }
                }
            }
        };
    }
}
