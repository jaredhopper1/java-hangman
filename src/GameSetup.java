
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameSetup {

    private int numGuess = 0;
    private int numLoops = 0;
    private Boolean alreadyGuessedThatLetter = false;


    public void Start(String selectedMovie) {
        String fixedMovie = selectedMovie;
        String hiddenMovie = fixedMovie; //new String(new char[fixedMovie.length()]);
        String lettersGuessed = "";


        char[] unwantedCharacters = {' '};

        fixedMovie = fixedMovie.replace(' ', '-');

        hiddenMovie = new String(new char[selectedMovie.length()]).replace('\0', '-');


        //start game
        System.out.println("We are playing hangman! The category is movies. The movie is below:");

        Scanner scanner = new Scanner(System.in);

        //Initial game loop
        for (int i = 20; i > 0; i--) {
            if (i == 20) {
                System.out.println("Current word " + hiddenMovie);
                System.out.println("You have " + numGuess + " guesses.");
                System.out.println("Type a letter into the box. The console will only count the first letter you type.");
                numGuess ++;
                numLoops ++;
            } else if (i > 1) {
                System.out.println("You have " + i + " guesses left. So far you have guessed " + lettersGuessed.toLowerCase() + "Choose another letter: ");
                System.out.println("Type a letter into the box. The console will only count the first letter you type.");
                System.out.println("Current word " + hiddenMovie);
                numGuess ++;
                numLoops ++;
            } else if (i == 0) {
                System.out.println("This is your last guess!");
                System.out.println("So far you have guessed " + lettersGuessed.toLowerCase());
                System.out.println("Current word " + hiddenMovie);
                numGuess ++;
                numLoops ++;
            } else {
                System.out.println("You are out of guesses! The movie was " + selectedMovie);
            }

            //user input
            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)) {
                //If you already guessed once check to make sure its not the same letter.

                    for(int x = 0; x <= lettersGuessed.length() - 1; x++) {
                        if(currentGuess == lettersGuessed.charAt(x)){
                            numGuess--;
                            numLoops--;

                            System.out.println("You have already selected that letter.");

                        }
                }

                //If this is not a letter that was already guessed
                //Check the logic to see where it is and reveal the letter in the word
                if (!alreadyGuessedThatLetter) {
                    for (int r = 0; r <= selectedMovie.length() - 1; r++) {
                        char current = selectedMovie.charAt(r);

                        //Convert answer to lowercase
                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hiddenMovie.toCharArray();
                            charHidden[r] = current;
                            hiddenMovie = String.valueOf(charHidden);

                        }

                        //Convert answer to uppercase
                       /* currentGuess = Character.toUpperCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hiddenMovie.toCharArray();
                            charHidden[r] = current;
                            hiddenMovie = String.valueOf(charHidden);
                        } */


                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numGuess++;
                    numLoops++;
                }

            }
            if (fixedMovie.equals(hiddenMovie)) {
                System.out.println("YOU WIN! The movies was " + selectedMovie);

                break;
            }
        }
    }
}




