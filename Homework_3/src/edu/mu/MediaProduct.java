package edu.mu;

import java.util.Objects;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public MediaProduct(MediaProduct product) {
		this.title = product.title;
		this.price = product.price;
		this.year = product.year;
		this.genre = product.genre;
	}
	
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}



	public MediaProduct() {
		
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

	@Override
	public String toString() {
		return "MediaProduct [title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}

//	public boolean equals(MediaProduct obj) {
//        if(this.title == obj.getTitle() && this.genre == obj.getGenre() && this.price == obj.getPrice() && this.year == obj.getYear()) {
//            return true;
//        }
//        return false;
//    }

//	@Override
//	public int hashCode() {
//		return Objects.hash(genre, price, title, year);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		MediaProduct other = (MediaProduct) obj;
		return genre == other.genre && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title) && year == other.year;
	}
	
}
