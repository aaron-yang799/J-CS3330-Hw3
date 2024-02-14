package edu.mu;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Yippee!");
		StockerManagerSingleton instance = StockerManagerSingleton.getInstance();
		System.out.println(instance.initializeStock());
		
		ArrayList<MediaProduct> listOfProducts = StockerManagerSingleton.getProducts();
		
		System.out.println("List of products before removeItem: ");
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());

		}
		
		instance.saveStock();
		
		instance.removeItem(listOfProducts.get(1));
		
		System.out.println("List of products after removeItem: \n");

		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n\n\n\n\n");
		
		
		System.out.println("\nList of products after updateItemPrice: \n");

		instance.updateItemPrice(listOfProducts.get(2), 23.13);
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n\n\n\n\n");
		
		MediaProduct temp = new CDRecordProduct(new MediaProduct("Monkey Track", 10.99, 2021, Genre.POP));

		System.out.println("\nList of products after addItem: \n");
		
		instance.addItem(temp);
		
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			System.out.println(listOfProducts.get(i));
			System.out.println(listOfProducts.get(i).getClass());
		}
		
		System.out.println("\n\n\n\n\n\n");
		ArrayList<VinylRecordProduct> vpr = new ArrayList<VinylRecordProduct>();
		System.out.println("\nList of VinylRecords only: \n");
		vpr = instance.getVinylRecordList(listOfProducts);
		
		for(int i = 0; i < vpr.size(); i++)
		{
			
			
			System.out.println(vpr.get(i));
			System.out.println((vpr.get(i)).getClass());
//			System.out.println("\n");
		}
		System.out.println("Total number of CDRecords:" + vpr.size());
		
		
		System.out.println("\n\n\n\n\n\n");
		ArrayList<CDRecordProduct> cdp = new ArrayList<CDRecordProduct>();
		System.out.println("\nList of CDRecords only: \n");
		cdp = instance.getCDRecordsList(listOfProducts);
		
		for(int i = 0; i < cdp.size(); i++)
		{
			
			
			System.out.println(cdp.get(i));
			System.out.println((cdp.get(i)).getClass());
//			System.out.println("\n");
		}
		System.out.println("Total number of CDRecords:" + cdp.size());
		
		
		System.out.println("\n\n\n\n\n\n");
		ArrayList<TapeRecordProduct> trp = new ArrayList<TapeRecordProduct>();
		System.out.println("\nList of TapeRecords only: \n");
		trp = instance.getTapeRecordList(listOfProducts);
		
		for(int i = 0; i < trp.size(); i++)
		{
			
			
			System.out.println(trp.get(i));
			System.out.println((trp.get(i)).getClass());
//			System.out.println("\n");
		}
		System.out.println("Total number of TapeRecords:" + trp.size());

		


		
	}
	
	

}
