package usantatecla.movies.v24;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String getStatement() {
		String result = "Rental Record for " + this.getName() + "\n";
		for (Rental rental : rentals) {
			result += "\t" + rental.getTitle() + "\t" + String.valueOf(rental.getMovieProperties().charge) + "\n";
		}
		result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : rentals) {
			result += rental.getMovieProperties().charge;
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : rentals) {
			result += rental.getMovieProperties().frequentRenterPoints;
		}
		return result;
	}

}
