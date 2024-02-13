package edu.mu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockerManagerSingleton {
	
	private static StockerManagerSingleton instance = null;
	private final static String filePath = "files/inventory.csv";
	public static ArrayList<MediaProduct> products;
	
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
				String[] fields = scanner.nextLine().split(",");
				switch(fields[0]) {
					case "CD": 
						products.add(new CDRecordProduct(new MediaProduct(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), Genre.valueOf(fields[4]))));
						break;
					case "Vinyl":
						products.add(new VinylRecordProduct(new MediaProduct(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), Genre.valueOf(fields[4]))));
						break;
					case "Tape":
						products.add(new TapeRecordProduct(new MediaProduct(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), Genre.valueOf(fields[4]))));
						break;
					default:
						products.add(new MediaProduct(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), Genre.valueOf(fields[4])));
						break;
				}
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

