package finco.framework.account;

import java.util.Date;

/**
* @author: Sumit Wankhede
*/

public class Entry implements IEntry {

	private Date date;
    private double amount;

    public Entry(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
	
}
