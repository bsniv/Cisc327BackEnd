package SharedClasses;


public class Transaction {

	public enum TransactionCodes {
		DEP, WDR, XFR, NEW, DEL, EOS
	}
	TransactionCodes CCC;
	String toAccountNumber;
	String amount;
	String fromAccountNumber;
	String accountName;
	
	
	
	public Transaction(TransactionCodes code, String toAccountNumber, String amount, String fromAccountNumber, String accountName) {
		CCC = code;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.fromAccountNumber = fromAccountNumber;
		this.accountName = accountName;
	}

	public String toString(){
		return  CCC.toString() + " " + toAccountNumber + " " + amount + " " + fromAccountNumber + " " + accountName;
	}
	
	public String getToAccountNumber(){
		System.out.println("Getting Account Number: " + toAccountNumber);
		return toAccountNumber;
	}
	
	public String getFromAccountNumber(){
		return fromAccountNumber;
	}
	
	public int getAmount(){
		System.out.println("Getting amount to be withdrawn.");
		return Integer.parseInt(amount);
	}
	
	public String getAccountName(){
		System.out.println("Getting Account Name: " + accountName);
		return accountName;
	}
	
	public TransactionCodes getTC(){
		return CCC;
	}
}
