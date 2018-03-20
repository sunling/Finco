package finco.framework.account;

import java.util.Date;

/**
* @author: Sumit Wankhede
*/

public class Entry implements IEntry {

	private Date date;
    private double amount;
    private String transaction_Type;

    public Entry(double amount, Date date, String transaction_Type) {
        this.amount = amount;
        this.date = date;
        this.transaction_Type = transaction_Type;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

	public String getTransaction_Type() {
		return transaction_Type;
	}
	
}
