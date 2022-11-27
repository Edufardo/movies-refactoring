package usantatecla.movies.v25;

public class MovieProperties {
    int frequentRenterPoints;
    double charge;

    public MovieProperties(double charge, int frequentRenterPoints) {
        this.charge = charge;
        this.frequentRenterPoints = frequentRenterPoints;
	}

    public double getCharge() {
		return this.charge;
	}
	
	public int getFrequentRenterPoints() {
		return this.frequentRenterPoints;
	}
}
