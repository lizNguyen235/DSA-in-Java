public class Rating {
    private int userID;
    private int movieID;
    private int score;
    private long time;

    public Rating(int userID, int movieID, int score, long time) {
        this.userID = userID;
        this.movieID = movieID;
        this.score = score;
        this.time = time;
    }

    public int getUserID() {
        return userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getScore() {
        return score;
    }

    public long getTime() {
        return time;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rating[" + userID + ", " + movieID + ", " + score + ", " + time + "]";
    }
}
