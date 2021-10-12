package documentView.views;

import documentView.models.*;
import documentView.types.Status;

import java.util.Scanner;

public class PlayerView {

    private Game game;
    private Scanner scanner;

    PlayerView(Game game){
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    void interact(){
        Board board = this.game.getBoard();
        Player player;
        if (this.game.getPlayers()[0].getStatus() == Status.MAKING_MOVE){
            player = this.game.getPlayers()[0];
        }else{
            player = this.game.getPlayers()[1];
        }

        System.out.println(player.getName() + " it's your move, select a column to place a chip");
        int column = -1;
        while(column == -1) {
            try {
                column = Integer.parseInt(scanner.nextLine());
                if (board.isAvailableMove(column)){
                    board.makeMove(column, player.getColor());
                }else{
                    System.out.println("Wrong Column chosen, try again!");
                    column = -1;
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Wrong Integer, try again!");
            } catch (NumberFormatException exception) {
                System.out.println("Not an Integer, try again!");
            }
        }

        this.game.setLastMoveColumn(column);
    }
}
