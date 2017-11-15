package SharedClasses;

public class User {

	private String accountNumber;
	private int accountBalance;
	private String userName;
	
	public User(String accountNumber, int accountBalance, String userName) {
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
		return accountBalance;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setAccountBalance(int newBalance){
		accountBalance = newBalance;
	}
}
