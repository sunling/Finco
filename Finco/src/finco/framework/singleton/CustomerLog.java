package finco.framework.singleton;

import java.util.Date;
import finco.framework.account.IAccount;
import finco.framework.account.IEntry;

/**
* @author Sumit Wankhede
*/

public class CustomerLog {
	private String customer_Name;
	private String account_No;
	private String account_Type;
	private String transaction_Type;
	private Date date;
	private double amount;

	public CustomerLog(IAccount account, IEntry entry) {
		super();
		this.customer_Name = account.getCustomer().getName();
		this.account_No = account.getAccountNo();
		this.account_Type = account.getAccountType();
		this.transaction_Type = entry.getTransaction_Type();
		this.date = entry.getDate();
		this.amount = entry.getAmount();
	}
	
	public String getName() {
		return customer_Name;
	}

	public String getAccount_No() {
		return account_No;
	}

	public String getAccount_Type() {
		return account_Type;
	}

	public String getTransaction_Type() {
		return transaction_Type;
	}

	public Date getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}
	
}
