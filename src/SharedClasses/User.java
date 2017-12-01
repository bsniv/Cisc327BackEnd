package SharedClasses;

public class User {

	private String accountNumber;
	private String accountBalance;
	private String userName;
	
	public User(String accountNumber, String accountBalance, String userName) {
		System.out.println("Constructing NEW user.");
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.userName = userName;
	}
	
	//TODO
	public String toString(){
		return accountNumber + " " + accountBalance + " " + userName;
	}

	public String getAccountNumber(){
		return accountNumber;
	}
	
	public String getBalance(){
		System.out.println("Getting balance of: " + this.toString());
		return accountBalance;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setAccountBalance(String newBalance){
		while (newBalance.length() <3)
			newBalance = "0" + newBalance;
		
		System.out.println("Setting new account balance to: " + newBalance);
		accountBalance = newBalance;
	}
}
