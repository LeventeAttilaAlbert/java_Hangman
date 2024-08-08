import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int playerMiss = 0; 
        String playWord = randomWord();
        String misses = "";
        char[] wordPlaceHolder = new char[playWord.length()];

        for (int i = 0; i<playWord.length(); i++) {
            wordPlaceHolder[i] = '_';
        }

        for (int i = 0; i < (playWord.length()+7); i++) {
            System.out.println(gallows[playerMiss]);
            System.out.print("\n");
            System.out.print("Word: " + Arrays.toString(wordPlaceHolder) + "\n");
            System.out.print("\n");
            System.out.print("Misses: " + misses + "\n");
            System.out.print("\n");
            System.out.println(playWord);
            System.out.print("\n");
            System.out.print("Guess: " + "\n");
            char playerGuess = scan.next().charAt(0);
            if (checkGuess(playWord, playerGuess)==true){
                for (int j = 0; j<playWord.length(); j++){
                    if (playWord.charAt(j) == playerGuess) {
                        wordPlaceHolder[j] = playerGuess;
                    }
                }
            }
            else {
                misses += playerGuess + " ";
                playerMiss++;
            }

            if (checkWin(wordPlaceHolder) == true){
                System.out.println("Congratulations! You've won!" + "\n\tThe word was: " + playWord);
                break;
            }
            else if (playerMiss + 1 == 7) {
                System.out.println(gallows[6]);
                System.out.println("\nRIP");
                System.out.println("The word was: " + playWord + "\n");
                break;
            }
            else{
                continue;
            }
        }
        scan.close();
    }

    public static String randomWord(){ 
        int wordNum = (int)(Math.random()*words.length);
        String wordChosen = words[wordNum];
        return wordChosen;
    }

    public static boolean checkGuess(String playWord, char playerGuess) {
        for (int i = 0; i<playWord.length(); i++){
            if(playWord.charAt(i) == Character.toLowerCase(playerGuess)) {
                return true;
                }   
            }    
        return false;
        }

    public static boolean checkWin(char[] wordPlaceHolder) {
        for (int i = 0; i< wordPlaceHolder.length; i++) {
            if (wordPlaceHolder[i] == '_'){
                return false;
            }
        }
        return true;
    }
}