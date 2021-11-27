package gameplayer;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * @author jsaho
 */
public class GamePlayer {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Beginning the game! Player 1: b & Player 2: r");
        System.out.println("Pick the column (0-6) you want to place your piece in!");
        
        char P1 = 'b';
        char P2 = 'r';
        char activePlayer = P2;
        
        while (game.isPlaying()) {
            if (activePlayer == P2) {
                System.out.println("Player 1's move:");
                activePlayer = P1;
            }
            else {
                System.out.println("Player 2's move:");
                activePlayer = P2;
            }
            
            int move;
            boolean invalid = true;
            
            while(invalid) {
                try {
                    move = getInput();
                    game.pickColumn(activePlayer, move);
                    invalid = false;
                }
                catch(InputMismatchException e) {
                    System.out.println("Please select a valid column!");
                }
            }
            System.out.println();
            game.displayGame();
        }
        System.out.println("Winner is: " + game.getWinner());
    }
    public static int getInput() {
        Scanner userInput = new Scanner(System.in);
        int move = 0;
        move = userInput.nextInt();
        if(move > 6 || move < 0) {
            System.out.println("Please select a valid column!");
            return getInput();
        }
        else {
            return move;
        }
    }
} 
