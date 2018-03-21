package bank.gui.component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddInterestDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double addInterest = 0.00;
	
    public AddInterestDialog() {
        super();

        setTitle("Add Interest");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(268, 126);
        setVisible(false);
        
        JLabel1.setText("Add");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(Color.black);
        JLabel1.setBounds(12, 12, 48, 24);
        
        JTextField_AddInterest.setEditable(true);
        getContentPane().add(JTextField_AddInterest);
        JTextField_AddInterest.setBounds(84, 12, 144, 24);
        
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36, 84, 84, 24);
        
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 84, 84, 24);

        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Cancel.addActionListener(lSymAction);
        //}}
        setBounds(430, 15, 275, 140);
    }


    JLabel JLabel1 = new JLabel();
    JTextField JTextField_AddInterest = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Cancel = new JButton();


    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Cancel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
    		addInterest= Double.parseDouble(JTextField_AddInterest.getText());
        dispose();
    }

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

	public double getAddInterest() {
		return addInterest;
	}
}