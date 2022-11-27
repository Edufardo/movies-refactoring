package usantatecla.movies.v25;

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
		final String TITLE = "Rental Record for %s '\n'";
		final String FOOTER_CHARGE = "Amount owed is %s '\n'";
		final String FOOTER_FREQUENT_POINTS = "You earned %s frequent renter points";

		String result = String.format(TITLE, this.getName());
		for (Rental rental : rentals) {
			result += "\t" + rental.getTitle() + "\t" + String.valueOf(rental.getMovieProperties().charge) + "\n";
		}
		result += String.format(FOOTER_CHARGE, this.formatString(this.getTotalCharge()));
		result += String.format(FOOTER_FREQUENT_POINTS, this.formatString(this.getTotalFrequentRenterPoints()));
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

	private String formatString(Object formatObject ){
		return String.valueOf(formatObject);
	}
}
