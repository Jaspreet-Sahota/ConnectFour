package gameplayer;
import java.util.Scanner;
/**
 * @author jsaho
 */
public class Game extends GamePlayer {
    int totColumns = 7;
    int totRows = 6;
    char[][] board;
    int[] currentRow;
    char winner;
    
    public Game() {
        this.board = new char[totRows][totColumns];
        this.currentRow = new int[totColumns];
        this.winner = '-';
        
        for(int row = 0; row < totRows; row++) {
            for(int col = 0; col < totColumns; col++) {
                board[row][col] = '_';
            }
        }
    }
    
    public void displayGame() {
        for(int row = totRows-1; row > -1; row--) {
            for(int col = 0; col < totColumns; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public void pickColumn(char player, int col) {
        if(currentRow[col] < totRows) {
            board[currentRow[col]++][col] = player;
        }
        else {
            Scanner S = new Scanner(System.in);
            System.out.println("Column is full, please select a different column!");
            pickColumn(player, S.nextInt());
        }
    }
    
    public boolean isPlaying() {
        boolean fullBoard = checkFullBoard();
        boolean win = checkWinner();
        if(fullBoard && !win) {
            this.winner = '=';
        }
        if(fullBoard || win) {
            return false;
        }
        else return true;
    }
    
    public boolean checkFullBoard() {
        for(int col = 0; col < currentRow.length; col++) {
            if(currentRow[col] < 6) {
                return false;
            }
            else return true;
        }
        return true;
    }
    
    public char getWinner() {
        return this.winner;
    }
    
    private boolean checkWinner() { //win across
        for(int row = 0; row < totRows; row++) {
            for(int col = 0; col < totColumns-3; col++) {
                if(board[row][col]=='b' && board[row][col+1]=='b' && board[row][col+2]=='b' && board[row][col+3]=='b') {
                    this.winner = 'b';
                    return true;
                }
                else if(board[row][col]=='r' && board[row][col+1]=='r' && board[row][col+2]=='r' && board[row][col+3]=='r') {
                    this.winner = 'r';
                    return true;
                }
            }
        }
        for(int row = 0; row < totRows-3; row++) { //win down
            for(int col = 0; col < totColumns; col++) {
                if(board[row][col]=='b' && board[row+1][col]=='b' && board[row+2][col]=='b' && board[row+3][col]=='b') {
                    this.winner = 'b';
                    return true;
                }
                else if(board[row][col]=='r' && board[row+1][col]=='r' && board[row+2][col]=='r' && board[row+3][col]=='r') {
                    this.winner = 'r';
                    return true;
                }
            }
        }
        for(int row = 3; row < totRows; row++) { //win diagonally(downwards)
            for(int col = 0; col < totColumns-3; col++) {
                if(board[row][col]=='b' && board[row-1][col+1]=='b' && board[row-2][col+2]=='b' && board[row-3][col+3]=='b') {
                    this.winner = 'b';
                    return true;
                }
                else if(board[row][col]=='r' && board[row-1][col+1]=='r' && board[row-2][col+2]=='r' && board[row-3][col+3]=='r') {
                    this.winner = 'r';
                    return true;
                }
            }
        }
        for(int row = 0; row < totRows-3; row++) { //win diagonally(upwards)
            for(int col = 0; col < totColumns-3; col++) {
                if(board[row][col]=='b' && board[row+1][col+1]=='b' && board[row+2][col+2]=='b' && board[row+3][col+3]=='b') {
                    this.winner = 'b';
                    return true;
                }
                else if(board[row][col]=='r' && board[row+1][col+1]=='r' && board[row+2][col+2]=='r' && board[row+3][col+3]=='r') {
                    this.winner = 'r';
                    return true;
                }
            }
        }
        return false;
    }
}
