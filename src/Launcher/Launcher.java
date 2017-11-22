package Launcher;
import BL.Core;
import DAL.Data;

public class Launcher {
	public static void main(String[] args) {
		if (args.length == 2){
			Data.setTransactionFilePath(args[1]);
			Data.setMasterAccountFilePath(args[0]);
			System.out.println("Received both arguments.");
		}
		else {
			Data.setTransactionFilePath(null);
			Data.setMasterAccountFilePath(null);
			System.out.println("Did not receive both arguments.");
		}
		Data data = new Data();
		System.out.println("Initializing Data.");
		Core core = new Core(data);
		System.out.println("Initializing Core.");
		core.start();
	}
}
