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
				case EOS: handleEOS(t); break;
			}
		}
		data.writeUsers(users);
	}
	
	//TODO
	public void handleDeposit(Transaction t){
		
	}
	
	//TODO
	public void handleWithdraw(Transaction t){
	
	}

	//TODO
	public void handleTransfer(Transaction t){
	
	}
	
	//TODO
	public void handleNew(Transaction t){
		
	}
	
	//TODO
	public void handleDelete(Transaction t){
		
	}
	
	//TODO
	public void handleEOS(Transaction t){
		
	}
	
	

}
