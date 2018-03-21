package finco.framework.mvc.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public abstract class BaseUI implements IMainUI {

    protected DefaultTableModel model;


    private JFrame jFrame;

    protected JPanel JPanel1 = new JPanel();
    protected JPanel JPanel2 = new JPanel();
    protected JPanel JPanel3 = new JPanel();
    protected JPanel JPanel4 = new JPanel();

    protected JScrollPane JScrollPane1;
    protected JTable JTable1;

    public BaseUI(DefaultTableModel tableModel) {
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

        JScrollPane1 = new JScrollPane();
        JTable1 = new JTable(model);
        JPanel1.add(JScrollPane1);
        JScrollPane1.setPreferredSize(new Dimension(444, 200));
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);

        JPanel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JPanel2.setPreferredSize(new Dimension(575, 45));
        jFrame.getContentPane().add(BorderLayout.PAGE_START, JPanel2);

        JPanel1.add(JPanel3);
        JPanel3.setLayout(new BoxLayout(JPanel3, BoxLayout.PAGE_AXIS));

        JPanel4.setLayout(new BorderLayout());
        jFrame.getContentPane().add(BorderLayout.PAGE_END, JPanel4);

        JButton JButton_Exit = new JButton();
        JButton_Exit.setText("Exit");
        JPanel4.add(BorderLayout.LINE_END, JButton_Exit);
        Dimension exitBtnDimen = new Dimension(96, 31);
        JButton_Exit.setPreferredSize(exitBtnDimen);
        JButton_Exit.setMaximumSize(exitBtnDimen);
        JButton_Exit.setMinimumSize(exitBtnDimen);
        JButton_Exit.addActionListener(e->System.exit(0));

        jFrame.addWindowListener(getWindowListener());

        configureTableHeader();
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

    private Dimension oprnBtnDimension = new Dimension(192, 33);
    @Override
    public void addOperationalButton(JButton button) {
        button.setPreferredSize(oprnBtnDimension);
        JPanel2.add(button);
    }

    private Dimension trnxBtnDimension = new Dimension(96, 33);
    @Override
    public void addTransactionalButton(JButton button) {
        JPanel3.add(button);
        button.setMinimumSize(trnxBtnDimension);
        button.setMaximumSize(trnxBtnDimension);
        button.setPreferredSize(trnxBtnDimension);
    }

    @Override
    public JFrame getFrame() {
        return jFrame;
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
