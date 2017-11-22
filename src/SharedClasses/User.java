package SharedClasses;

public class User {

	private String accountNumber;
	private int accountBalance;
	private String userName;
	
	public User(String accountNumber, int accountBalance, String userName) {
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
	
	public int getBalance(){
		System.out.println("Getting balance of: " + this.toString());
		return accountBalance;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setAccountBalance(int newBalance){
		System.out.println("Setting new account balance to: " + newBalance);
		accountBalance = newBalance;
	}
}
