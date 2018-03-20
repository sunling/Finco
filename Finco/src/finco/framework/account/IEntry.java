package finco.framework.account;

import java.util.Date;

/**
* @author: Sumit Wankhede
*/

public interface IEntry {
	public Date getDate() ;

    public double getAmount();

	public String getTransaction_Type();
}
