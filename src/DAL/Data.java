package DAL;

import java.io.FileWriter;
import SharedClasses.Transaction;
import SharedClasses.User;
import java.io.*;
import java.util.LinkedList;

/**
 * data class - responsible for data fetching and updating
 *
 */
public class Data {

    private static String transactionFilePath="";
    private static String masterAccountFilePath="";
    private static String validAccountsFilePath="";

    
    public LinkedList<Transaction> readTransactionFile(){
    	LinkedList<Transaction> transactions = new LinkedList<Transaction>();
		try (BufferedReader br = new BufferedReader(new FileReader(transactionFilePath))) {
			String line;
			line = br.readLine();
			while (line != null) {
				transactions.add(parseLineToTransaction(line));
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return transactions;
    }
    
    private Transaction parseLineToTransaction(String line){
    	String[] parts = line.split(" ");
    	return new Transaction(
    			Transaction.TransactionCodes.valueOf(parts[0]),
    			parts[1],
    	    	parts[2],
    	    	parts[3],
    			parts[4]);
    }
    
    
    public LinkedList<User> readAccountFile(){
    	LinkedList<User> users = new LinkedList<User>();
		try (BufferedReader br = new BufferedReader(new FileReader(masterAccountFilePath))) {

			String line;
			line = br.readLine();
			while (line != null) {
				users.add(parseLineToUser(line));
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return users;
    }
    
    
    private User parseLineToUser(String line){
    	String[] parts = line.split(" ");
    	return new User(parts[0],parts[1],parts[2]);
    }
    
        
    
    
    public void writeUsers(LinkedList<User> users) {
        try {
        	FileWriter writer = new FileWriter(masterAccountFilePath, false);
        	PrintWriter printWriter = new PrintWriter(writer);
        	for (User t : users)
        		printWriter.printf("%s" + "%n", t.toString());
        	printWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
        	FileWriter writer = new FileWriter(validAccountsFilePath, false);
        	PrintWriter printWriter = new PrintWriter(writer);
        	for (User t : users)
        		printWriter.print(t.getAccountNumber());
        	printWriter.print("0000000");
        	printWriter.close();
        }
        catch (Exception e ) {
        	e.printStackTrace();
        }
    }
    
    

    public static void setTransactionFilePath(String path){
    	if (path == null)
    		transactionFilePath = System.getProperty("user.dir")+"\\transactions.txt";
    	else
    		transactionFilePath = System.getProperty("user.dir")+"\\"+path;
    }
    
    public static void setMasterAccountFilePath(String path){
    	if (path == null)
    		masterAccountFilePath = System.getProperty("user.dir")+"\\users.txt";
    	else
    		masterAccountFilePath = System.getProperty("user.dir")+"\\"+path;
    }
    
    public static void setValidAccountsFilePath(String path)
    {
    	if (path == null)
    		validAccountsFilePath = System.getProperty("user.dir")+"\\validUsers.txt";
    	else
    		validAccountsFilePath = System.getProperty("user.dir")+"\\"+path;
    		
    }

}
