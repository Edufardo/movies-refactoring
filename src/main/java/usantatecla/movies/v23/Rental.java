package usantatecla.movies.v23;

public class Rental {

	private Movie movie;
	
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
    public MovieProperties getMovieProperties(){
        return this.movie.getProperties(daysRented);
    }
	
	public int getDaysRented() {
		return daysRented;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public String getTitle(){
		return movie.getTitle();
	}
	
}
