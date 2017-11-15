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
		int balance = user.getBalance();
		balance+=t.getAmount();
		user.setAccountBalance(balance);
	}
	
	public void handleWithdraw(Transaction t){
		User user = findUser(t.getToAccountNumber());
		int balance = user.getBalance();
		balance-=t.getAmount();
		user.setAccountBalance(balance);	
	}

	public void handleTransfer(Transaction t){
		User toUser = findUser(t.getToAccountNumber());
		User fromUser = findUser(t.getFromAccountNumber());

		int fromBalance = fromUser.getBalance();
		fromBalance-=t.getAmount();
		fromUser.setAccountBalance(fromBalance);			

		int toBalance = toUser.getBalance();
		toBalance+=t.getAmount();
		toUser.setAccountBalance(toBalance);			
	}
	
	public void handleNew(Transaction t){
		users.add(new User(t.getFromAccountNumber(),0,t.getAccountName()));
	}
	
	
	public void handleDelete(Transaction t){
		User user = findUser(t.getToAccountNumber());
		users.remove(user);
	}
	
	private User findUser(String accountNumber){
		for (User user : users)
			if (accountNumber.equals(user.getAccountNumber()))
				return user;
		return null;
	}

}
