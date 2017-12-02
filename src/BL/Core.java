package BL;

import java.util.LinkedList;

import DAL.Data;
import SharedClasses.Transaction;
import SharedClasses.User;

public class Core {

	Data data;
	LinkedList<User> users;
	public Core(Data data) {
		this.data = data;
	}
	
	public void start(){
		users = data.readAccountFile();
		LinkedList<Transaction> transactions = data.readTransactionFile();
		for (Transaction t : transactions){
			System.out.println("Working on transaction: "+t.toString());
			switch(t.getTC()){
				case DEL: handleDelete(t); break;
				case NEW: handleNew(t); break;
				case DEP: handleDeposit(t); break;
				case WDR: handleWithdraw(t); break;
				case XFR: handleTransfer(t); break;
			}
		}
		data.writeUsers(users);
	}
	
	//TODO
	public void handleDeposit(Transaction t){
		User user = findUser(t.getToAccountNumber());
		String balance = user.getBalance();
		balance=Integer.toString(Integer.parseInt(balance)+t.getAmount());;
		user.setAccountBalance(balance);
	}
	
	public void handleWithdraw(Transaction t){
		System.out.println("Transaction of type WDR was detected.");
		User user = findUser(t.getToAccountNumber());
		if (user == null)
		{
			System.out.println("User not found: " + t.getToAccountNumber());
			return;
		}
		String balance = user.getBalance();
		balance=Integer.toString(Integer.parseInt(balance)-t.getAmount());
		
		if (Integer.parseInt(balance) < 0)
		{
			System.out.println("Invalid withdrawal, amount greater than balance.");
			return;
		}
		user.setAccountBalance(balance);	
		System.out.println("Balance of user:" + user.toString() + " changed to: " + user.getBalance());
	}

	public void handleTransfer(Transaction t){
		User toUser = findUser(t.getToAccountNumber());
		User fromUser = findUser(t.getFromAccountNumber());

		String fromBalance = fromUser.getBalance();
		fromBalance=Integer.toString(Integer.parseInt(fromBalance)-t.getAmount());
		if (Integer.parseInt(fromBalance) < 0)
		{
			System.out.println("Invalid transfer, amount greater than balance.");
			return;
		}
		fromUser.setAccountBalance(fromBalance);			
		
		String toBalance = toUser.getBalance();
		toBalance=Integer.toString(Integer.parseInt(toBalance)+t.getAmount());
		toUser.setAccountBalance(toBalance);			
	}
	
	public void handleNew(Transaction t){
		System.out.println("Transaction of type NEW was detected.");
		if (findUser(t.getToAccountNumber())!=null){
			System.out.println("Invalid account creation, account number already in use.");
			return;
		}
		users.add(new User(t.getToAccountNumber(),"000",t.getAccountName()));
		System.out.println("User added to LinkedList: " + users.getFirst().toString());
	}
	
	
	public void handleDelete(Transaction t){
		User user = findUser(t.getToAccountNumber());
		if (user.getBalance() != "000")
		{
			System.out.println("Invalid account deletion, balance is not 0.");
			return;
		}
		
		if (!user.getUserName().equals(t.getAccountName()))
		{
			System.out.println("Invalid account deletion, account name does not match name in transaction.");
			return;
		}
			users.remove(user);
	}
	
	private User findUser(String accountNumber){
		System.out.println("Finding user tied to account number:" + accountNumber);
		for (User user : users)
			if (accountNumber.equals(user.getAccountNumber()))
			{
				System.out.println("User found: " + user.toString());
				return user;
			}
		System.out.println("User not found.");
		return null;
	}

}
