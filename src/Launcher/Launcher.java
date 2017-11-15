package Launcher;
import BL.Core;
import DAL.Data;

public class Launcher {
	public static void main(String[] args) {
		if (args.length == 2){
			Data.setTransactionFilePath(args[1]);
			Data.setMasterAccountFilePath(args[0]);
		}
		else {
			Data.setTransactionFilePath(null);
			Data.setMasterAccountFilePath(null);
		}
		Data data = new Data();
		Core core = new Core(data);
		core.start();
	}
}
