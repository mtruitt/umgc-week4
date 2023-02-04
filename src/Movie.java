class Movie {
    private String title;
    private int year;
    private String rating;

    public Movie(String title, int year, String rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie: " + title + "\nYear: " + year + "\nRating: " + rating;
    }
}
