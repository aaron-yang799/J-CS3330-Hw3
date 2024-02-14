package edu.mu;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
        String RESET = "\u001B[0m";
		String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
		
		StockerManagerSingleton instance = StockerManagerSingleton.getInstance();
		System.out.println(instance.initializeStock());
		
		ArrayList<MediaProduct> listOfProducts = StockerManagerSingleton.getProducts();
		
		System.out.println("Result of savStock: " + GREEN + instance.saveStock() + RESET);
		
		System.out.println("\nList of products including the class: ");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());

		}
		
		System.out.println("\n\n");
		
		System.out.println("Result of removeItem used on the second item: " + GREEN + instance.removeItem(listOfProducts.get(1)) + RESET);
				
		System.out.println("\nResult of updateItemPrice used on Baby Shark (new price: 23.13, previous price: 10.99): " + GREEN + instance.updateItemPrice(listOfProducts.get(2), 23.13) + RESET);
		
		System.out.println("\nList of products after updateItemPrice and removeItem: \n");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
//			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n");
		
		MediaProduct temp = new CDRecordProduct(new MediaProduct("Test Track", 10.99, 2021, Genre.POP));
		
		System.out.println("Result of addItem (adding: Test Track, CDRecordProduct): " + GREEN + instance.addItem(temp) + RESET);
		
		System.out.println("\nList of products after adding Test Track: \n");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
//			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n");
		ArrayList<VinylRecordProduct> vpr = new ArrayList<VinylRecordProduct>();
		System.out.println("\nList of VinylRecords only: \n");
		vpr = instance.getVinylRecordList(listOfProducts);
		
		for(int i = 0; i < vpr.size(); i++)
		{			
			System.out.println(vpr.get(i));
			System.out.println((vpr.get(i)).getClass());
		}
		System.out.println("\nTotal number of CDRecords: " + YELLOW + vpr.size() + RESET);
		
		
		System.out.println("\n\n");
		
		ArrayList<CDRecordProduct> cdp = new ArrayList<CDRecordProduct>();
		System.out.println("\nList of CDRecords only: \n");
		cdp = instance.getCDRecordsList(listOfProducts);
		
		for(int i = 0; i < cdp.size(); i++)
		{	
			System.out.println(cdp.get(i));
			System.out.println((cdp.get(i)).getClass());
		}
		System.out.println("\nTotal number of CDRecords: " + YELLOW + cdp.size() + RESET);
		
		
		System.out.println("\n\n");
		ArrayList<TapeRecordProduct> trp = new ArrayList<TapeRecordProduct>();
		System.out.println("\nList of TapeRecords only: \n");
		trp = instance.getTapeRecordList(listOfProducts);
		
		for(int i = 0; i < trp.size(); i++)
		{	
			System.out.println(trp.get(i));
			System.out.println((trp.get(i)).getClass());
		}
		System.out.println("\nTotal number of TapeRecords: " + YELLOW + trp.size() + RESET);

		
		System.out.println("\n\nTapes below $16: \n");
		ArrayList<MediaProduct> budget = new ArrayList<>();
		budget = instance.getMediaProductBelowPrice(16);
		for(int i = 0; i < budget.size(); i++) {	
			System.out.println(budget.get(i));
		}
		
	}
	
	

}
