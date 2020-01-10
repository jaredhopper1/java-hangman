import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class GuessTheMovie {


    public static void main(String[] args) throws Exception {
        //global variables
        String movie = "";
        List<String> movies = new ArrayList<String>();
        String selectedMovie = "";


        //initialize scanner and file
        Scanner movieTextFile;
        movieTextFile = new Scanner(new File("MovieList.txt"));

        //Create the movies array from the text file
        while (movieTextFile.hasNext()) {
            movie = movieTextFile.nextLine();
            movies.add(movie);
                    }
        movieTextFile.close();

        //randomly select movie
        Random r = new Random();
        int randomMovie = r.nextInt(movies.size());
        selectedMovie = movies.get(randomMovie);

        GameSetup game = new GameSetup();
        game.Start(selectedMovie);

        }


    }


