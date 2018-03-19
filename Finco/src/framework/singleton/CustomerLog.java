package finco.framework.singleton;

import java.util.Date;

/**
* @author Sumit Wankhede
*/

public class CustomerLog {
	private String name;
	private String account_No;
	private String account_Type;
	private String transaction_Type;
	private Date date;
	private String amount;

	public CustomerLog(String name, String account_No, String account_Type, String transaction_Type, Date date,
			String amount) {
		super();
		this.name = name;
		this.account_No = account_No;
		this.account_Type = account_Type;
		this.transaction_Type = transaction_Type;
		this.date = date;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
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

	public String getAmount() {
		return amount;
	}
	
}
