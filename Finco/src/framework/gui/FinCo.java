package framework.gui;

public class FinCo {

    public void submitOperation(Command cmd) {
        execute(cmd);
    }

    public void submitTransaction(Command cmd) {
        execute(cmd);
    }

    public void execute(Command cmd) {
        cmd.execute();
    }
}
