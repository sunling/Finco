package finco.framework.mvc.model;

public class CustomerAccountDTO {

    private String accountType;
    private String accountNo;
    private String customerName;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;

    public boolean isValid() {
       //return !accountNo.isEmpty() && !customerName.isEmpty() && !email.isEmpty() && !accountType.isEmpty(); 
       return accountNo != null && customerName != null && email != null &&
            !(accountNo.equals("") || customerName.equals("") || email.equals(""));
    		//return accountNo != null || customerName != null || email != null || accountType != null || accountType != "" || accountNo != "" || customerName != "" || email != "";
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
