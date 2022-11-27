package usantatecla.movies.v26;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private List<Rental> rentals;

	public Statement(List<Rental> rentals) {
		this.rentals = new ArrayList<Rental>();
	}

    public String getStatement(List<Rental> rentals, String name){
        final String TITLE = "Rental Record for %s '\n'";
        final String FOOTER_CHARGE = "Amount owed is %s '\n'";
        final String FOOTER_FREQUENT_POINTS = "You earned %s frequent renter points";
    
        String result = String.format(TITLE, name);
        for (Rental rental : rentals) {
            result += this.formatResult(rental);
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

    private String formatResult(Rental rental){
        return "\t" + rental.getTitle() + "\t" + String.valueOf(rental.getMovieProperties().charge) + "\n";
    }
}
