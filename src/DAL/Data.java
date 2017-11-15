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
    
    //TODO
    private Transaction parseLineToTransaction(String line){
    	return null;
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
    
    
  //TODO
    private User parseLineToUser(String line){
    	return null;
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

}
