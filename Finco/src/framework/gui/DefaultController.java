package framework.gui;

import javax.swing.table.DefaultTableModel;

public class DefaultController {

    protected IMainUI ui;
    protected FinCo finCo;
    protected DefaultTableModel model;

    public DefaultController(FinCo finCo, IMainUI ui, DefaultTableModel model) {
        this.finCo = finCo;
        this.ui = ui;
        this.model = model;

        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("Amount");

        initOperationalButtons();
        initTransactionalButtons();
    }

    protected void initOperationalButtons() {
        ui.addOperationalButton("Add account", new Command() {
            @Override
            public void execute() {
                Object[] rowdata = new Object[4];
                rowdata[0] = "1";
                rowdata[1] = "2";
                rowdata[2] = "3";
                rowdata[3] = 100;
                model.addRow(rowdata);
            }
        });
    }

    protected void initTransactionalButtons() {

    }
}
