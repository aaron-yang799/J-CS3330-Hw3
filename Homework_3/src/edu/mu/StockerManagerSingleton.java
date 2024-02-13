package edu.mu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockerManagerSingleton {
	
	private static StockerManagerSingleton instance = null;
	private final static String filePath = "files/inventory.csv";
	private static ArrayList<MediaProduct> products;
	
	private StockerManagerSingleton() {
		products = new ArrayList<MediaProduct>();
	}
	
	public static StockerManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockerManagerSingleton();
		}
		return instance;
	}
	
	public boolean initializeStock() {
		try{
			FileInputStream inputStream = new FileInputStream(filePath);
		
			Scanner scanner = new Scanner(inputStream);
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				
			}
			scanner.close();
			inputStream.close();
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
			
	}
}

