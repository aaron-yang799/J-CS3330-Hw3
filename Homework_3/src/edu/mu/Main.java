package edu.mu;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		StockerManagerSingleton instance = StockerManagerSingleton.getInstance();
		System.out.println(instance.initializeStock());
		
		ArrayList<MediaProduct> listOfProducts = StockerManagerSingleton.getProducts();
		
		System.out.println("Result of savStock: " + instance.saveStock());
		
		System.out.println("\nList of products including the class: ");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());

		}
		
		System.out.println("\n\n");
		
		System.out.println("Result of removeItem used on the second item: " + instance.removeItem(listOfProducts.get(1)));
				
		System.out.println("\nResult of updateItemPrice used on Baby Shark (new price: 23.13, previous price: 10.99): " +instance.updateItemPrice(listOfProducts.get(2), 23.13));
		
		System.out.println("\nList of products after updateItemPrice and removeItem: \n");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
//			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n");
		
		MediaProduct temp = new CDRecordProduct(new MediaProduct("Test Track", 10.99, 2021, Genre.POP));
		
		System.out.println("Result of addItem (adding: Test Track, CDRecordProduct): " + instance.addItem(temp));
		
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
		System.out.println("\nTotal number of CDRecords: " + vpr.size());
		
		
		System.out.println("\n\n");
		
		ArrayList<CDRecordProduct> cdp = new ArrayList<CDRecordProduct>();
		System.out.println("\nList of CDRecords only: \n");
		cdp = instance.getCDRecordsList(listOfProducts);
		
		for(int i = 0; i < cdp.size(); i++)
		{	
			System.out.println(cdp.get(i));
			System.out.println((cdp.get(i)).getClass());
		}
		System.out.println("\nTotal number of CDRecords: " + cdp.size());
		
		
		System.out.println("\n\n");
		ArrayList<TapeRecordProduct> trp = new ArrayList<TapeRecordProduct>();
		System.out.println("\nList of TapeRecords only: \n");
		trp = instance.getTapeRecordList(listOfProducts);
		
		for(int i = 0; i < trp.size(); i++)
		{	
			System.out.println(trp.get(i));
			System.out.println((trp.get(i)).getClass());
		}
		System.out.println("\nTotal number of TapeRecords: " + trp.size());

		
		System.out.println("\n\nTapes below $16:");
		ArrayList<MediaProduct> budget = new ArrayList<>();
		budget = instance.getMediaProductBelowPrice(16);
		for(int i = 0; i < budget.size(); i++) {	
			System.out.println(budget.get(i));
		}
		
	}
	
	

}
