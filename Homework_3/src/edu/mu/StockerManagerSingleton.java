package edu.mu;

import java.io.FileInputStream;
import java.io.FileWriter;
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

	public static ArrayList<MediaProduct> getProducts() {
		return products;
	}

	public static void setProducts(ArrayList<MediaProduct> products) {
		StockerManagerSingleton.products = products;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		boolean flag = false;
		
		MediaProduct temp = new MediaProduct(product);
				
		for(int i = 0; i < products.size(); i++)
		{
			MediaProduct currentProduct = products.get(i);
			if(currentProduct.equals(temp)) {
				currentProduct.setPrice(newPrice);
				flag = true;
			}
		}
		return flag;
	}

	
	public boolean addItem(MediaProduct product) {
		if(product == null) {
			return false;
		}
		products.add(product);
		return true;
		
	}
	
	public boolean removeItem(MediaProduct product) {
        for(int i = 0; i < products.size(); ++i) {
            if(products.get(i).equals(product)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
	
	public boolean saveStock() {
		try (FileWriter writer = new FileWriter(filePath)) {
			
			writer.write("Type,Title,Price,Year,Genre\n");
			String Type = "";
			for(int i = 0; i < products.size(); i++) {
				switch (products.get(i).getClass().getSimpleName()) {
	
				case "CDRecordProduct":
					Type = "CD";
					break;
				
				case "VinylRecordProduct":
					Type = "Vinyl";
					break;
				
				case "TapeRecordProduct":
					Type = "Tape";
					break;
				
				default:
					break;
				}
				
				writer.write(Type + "," + 
							 products.get(i).getTitle() + "," +
							 products.get(i).getPrice() + "," +
							 products.get(i).getYear() + "," +
							 products.get(i).getGenre() + "\n");
			}
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void printListOfMediaProduct(ArrayList<MediaProduct>productList)
	{
		for(int i = 0; i < productList.size(); i++)
		{
			System.out.println(productList.get(i));
		}
	}
	
	public ArrayList<VinylRecordProduct>getVinylRecordList(ArrayList<MediaProduct> productList)
	{
		VinylRecordProduct class_compare = new VinylRecordProduct(productList.get(0));
		//VinylRecordProduct temp = new VinylRecordProduct();
		ArrayList<VinylRecordProduct> vpr = new ArrayList<VinylRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++)
		{


			//System.out.println("ProductList" + (productList.get(i)).getClass());
			//System.out.println("NewJoin" + (new VinylRecordProduct(productList.get(i))).getClass());
			if((class_compare.getClass().equals((productList.get(i)).getClass())))
			{
				vpr.add(VinylRecordProduct.class.cast(productList.get(i)));
				
			}
		}
		return vpr;
		
	}
	
	public ArrayList<CDRecordProduct>getCDRecordsList(ArrayList<MediaProduct> productList)
	{
		CDRecordProduct class_compare = new CDRecordProduct(productList.get(0));
		//VinylRecordProduct temp = new VinylRecordProduct();
		ArrayList<CDRecordProduct> vpr = new ArrayList<CDRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++)
		{


			//System.out.println("ProductList" + (productList.get(i)).getClass());
			//System.out.println("NewJoin" + (new VinylRecordProduct(productList.get(i))).getClass());
			if((class_compare.getClass().equals((productList.get(i)).getClass())))
			{
				vpr.add(CDRecordProduct.class.cast(productList.get(i)));
				
			}
		}
		return vpr;
	}
	
	
	public ArrayList<TapeRecordProduct>getTapeRecordList(ArrayList<MediaProduct> productList)
	{
		TapeRecordProduct class_compare = new TapeRecordProduct(productList.get(0));
		//VinylRecordProduct temp = new VinylRecordProduct();
		ArrayList<TapeRecordProduct> vpr = new ArrayList<TapeRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++)
		{


			//System.out.println("ProductList" + (productList.get(i)).getClass());
			//System.out.println("NewJoin" + (new VinylRecordProduct(productList.get(i))).getClass());
			if((class_compare.getClass().equals((productList.get(i)).getClass())))
			{
				vpr.add(TapeRecordProduct.class.cast(productList.get(i)));
				
			}
		}
		return vpr;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		ArrayList<MediaProduct> budgetList = new ArrayList<>();
		for(int i = 0; i < products.size(); ++i) {
			if(products.get(i).getPrice() < maxPrice) 
				budgetList.add(products.get(i));
		}
		return budgetList;
	}
}

