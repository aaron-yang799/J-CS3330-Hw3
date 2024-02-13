package edu.mu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Yippee!");
		StockerManagerSingleton instance = StockerManagerSingleton.getInstance();
		System.out.println(instance.initializeStock());
		System.out.println(StockerManagerSingleton.products.get(1));
	}

}
