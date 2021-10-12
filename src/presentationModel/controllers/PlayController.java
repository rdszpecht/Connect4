package presentationModel.controllers;

import presentationModel.models.Board;
import presentationModel.models.Game;
import presentationModel.models.Player;
import presentationModel.types.*;

import java.util.Scanner;

public class PlayController extends Controller {
    private Game game;
    private Scanner scanner;

    public PlayController(Game game) {
        super(game);
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public boolean isWiningCondition(){
        return this.game.isWiningCondition();
    }

    public boolean isDraw(){
        return this.game.isDraw();
    }

    public void makeMove(){
        Board board = this.game.getBoard();
        Player player;
        if (this.game.getPlayers()[0].getStatus() == Status.MAKING_MOVE){
            player = this.game.getPlayers()[0];
        }else{
            player = this.game.getPlayers()[1];
        }

        int column = -1;
        while(column == -1) {
            try {
                column = Integer.parseInt(scanner.nextLine());
                if (board.isAvailableMove(column)){
                    board.makeMove(column, player.getColor());
                }else{
                    column = -1;
                }
            } catch (IndexOutOfBoundsException exception) {

            } catch (NumberFormatException exception) {

            }
        }

        this.game.setLastMoveColumn(column);
    }
    public GameState getGameState(){
        return this.game.getGameState();
    }

    public Player getWinner(){
        return this.game.getWinner();
    }

    public void next(){
        this.game.next();
    }
}
