import java.util.*;
import java.io.File;

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        /* code here */
        ArrayList<Rating> ra = new ArrayList<Rating>();
        File f = new File(ratingPath);
        try {
            Scanner sc = new Scanner(f);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split(",");
                ra.add(new Rating(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                        Long.parseLong(arr[3])));
            }
            sc.close();
            return ra; /* change here */
        } catch (Exception e) {
            System.out.println("khong the doc file rating");
            return new ArrayList<Rating>();
        }
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        /* code here */
        ArrayList<Movie> mv = new ArrayList<Movie>();
        File f = new File(moviePath);
        try {
            Scanner sc = new Scanner(f);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                ArrayList<String> genres = new ArrayList<String>();
                String[] type = arr[2].split("-");
                for (int i = 0; i < type.length; i++) {
                    genres.add(type[i]);
                }
                mv.add(new Movie(id, name, genres));
            }
            sc.close();
            return mv; /* change here */
        } catch (Exception e) {
            System.out.println("khong the doc file Movie");
            return new ArrayList<Movie>();
        }

    }

    private ArrayList<User> loadUsers(String userPath) {
        /* code here */
        ArrayList<User> us = new ArrayList<User>();
        File f = new File(userPath);
        try {
            Scanner sc = new Scanner(f);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split(",");
                us.add(new User(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], arr[4]));
            }
            sc.close();
            return us; /* change here */
        } catch (Exception e) {
            System.out.println("khong the doc file user");
            return new ArrayList<User>();
        }

    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        /* code here */
        ArrayList<Integer> movieID = new ArrayList<Integer>();
        ArrayList<Movie> newMovies = new ArrayList<Movie>();
        for (Rating r : ratings) {
            if (r.getUserID() == userId && r.getScore() >= rating) {
                movieID.add(r.getMovieID());
            }
        }
        for (Movie m : movies) {
            if (movieID.contains(m.getId())) {
                newMovies.add(m);
            }
        }

        for (int i = 1; i < newMovies.size(); i++) {
            for (int j = 0; j < newMovies.size() - i; j++) {
                if (newMovies.get(j).getName().compareTo(newMovies.get(j + 1).getName()) > 0) {
                    Movie tmp = newMovies.get(j);
                    newMovies.set(j, newMovies.get(j + 1));
                    newMovies.set(j + 1, tmp);
                }
            }
        }
        
        return newMovies; /* change here */
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        /* code here */
        ArrayList<User> us = new ArrayList<User>();
        ArrayList<Integer> userID = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> userID_score = new ArrayList<ArrayList<Integer>>();
        int score = -1;
        for (Rating r : ratings) {
            if (r.getUserID() == userId && r.getMovieID() == movieId) {
                score = r.getScore();
            }
            if (r.getMovieID() == movieId) {
                ArrayList<Integer> s = new ArrayList<Integer>();
                s.add(r.getUserID());
                s.add(r.getScore());
                userID_score.add(s);
            }
        }

        for (int i = 0; i < userID_score.size(); i++) {
            if (userID_score.get(i).get(1) == score && userID_score.get(i).get(0) != userId) {
                userID.add(userID_score.get(i).get(0));
            }
        }

        for (User m : users) {
            if (userID.contains(m.getId())) {
                us.add(m);
            }
        }

        return us; /* change here */
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        /* code here */
        ArrayList<String> name = new ArrayList<String>();
        HashMap<Integer, Integer> name_score = new HashMap<>();
        for (Rating r : ratings) {
            if (r.getScore() < 4) {
                continue;
            }
            if (!name_score.containsKey(r.getMovieID())) {
                name_score.put(r.getMovieID(), 1);
            } else {
                name_score.replace(r.getMovieID(), name_score.get(r.getMovieID()) + 1);
            }
        }
        for (Movie m : movies) {
            if (name_score.containsKey(m.getId()) && name_score.get(m.getId()) > 1) {
                name.add(m.getName());
            }
        }

        Collections.sort(name);
        return name; /* change here */
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k,
            int rating) {
        /* code here */
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> userID = new ArrayList<Integer>();
        HashSet<Integer> movieID = new HashSet<Integer>();

        for (User u : users) {
            if (u.getOccupation().equals(occupation) && u.getGender().equals(gender)) {
                userID.add(u.getId());
            }
        }

        for (Rating r : ratings) {
            if (r.getScore() != rating) {
                continue;
            }

            if (userID.contains(r.getUserID())) {
                movieID.add(r.getMovieID());
            }
        }

        for (Movie m : movies) {
            if (movieID.contains(m.getId())) {
                name.add(m.getName());
            }
        }

        Collections.sort(name);
        k = Math.min(k, name.size());
        name.retainAll(name.subList(0, k));
        return name; /* change here */
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        /* code here */
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> userID = new ArrayList<Integer>();
        HashSet<Integer> movieID = new HashSet<Integer>();
        for (User u : users) {
            if (u.getOccupation().equals(occupation)) {
                userID.add(u.getId());
            }
        }

        for (Rating r : ratings) {
            if (r.getScore() >= rating) {
                continue;
            }

            if (userID.contains(r.getUserID())) {
                movieID.add(r.getMovieID());
            }
        }

        for (Movie m : movies) {
            if (movieID.contains(m.getId())) {
                name.add(m.getName());
            }
        }

        Collections.sort(name);
        k = Math.min(k, name.size());
        name.retainAll(name.subList(0, k));
        return name; /* change here */
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        /* code here */
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<HashSet<Integer>> userID = new ArrayList<HashSet<Integer>>();
        ArrayList<String> nameType = new ArrayList<String>();
        ArrayList<Integer> movieID = new ArrayList<Integer>();
        HashSet<String> compare = new HashSet<String>();

        userID.add(new HashSet<Integer>());
        userID.add(new HashSet<Integer>());

        for (User u : users) {
            if (u.getGender().equals("M")) {
                userID.get(0).add(u.getId());
            } else {
                userID.get(1).add(u.getId());
            }
        }

        if (userID.get(0).contains(userId)) {
            userID.remove(1);
        } else {
            userID.remove(0);
        }

        long max = -1;
        Integer movieId = 0;
        for (Rating r : ratings) {
            if (r.getScore() < rating) {
                continue;
            }

            if (userID.get(0).contains(r.getUserID())) {
                movieID.add(r.getMovieID());
            }

            if (max < r.getTime() && r.getUserID() == userId) {
                max = r.getTime();
                movieId = r.getMovieID();
            }
        }

        for (Movie m : movies) {
            if (m.getId() == movieId) {
                nameType.addAll(m.getGenres());
                break;
            }
        }

        for (Movie m : movies) {
            if (!movieID.contains(m.getId())) {
                continue;
            }
            compare.addAll(m.getGenres());
            compare.addAll(nameType);
            if (compare.size() < m.getGenres().size() + nameType.size()) {
                name.add(m.getName());
            }
            compare.clear();
        }
        Collections.sort(name);
        k = Math.min(k, name.size());
        name.retainAll(name.subList(0, k));
        return name; /* change here */
    }
}