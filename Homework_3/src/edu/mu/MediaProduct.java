package edu.mu;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public MediaProduct(MediaProduct mediaProduct) {
		this.title = mediaProduct.title;
		this.price = mediaProduct.price;
		this.year = mediaProduct.year;
		this.genre = mediaProduct.genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
