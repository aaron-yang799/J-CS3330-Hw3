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
		
	}

}
