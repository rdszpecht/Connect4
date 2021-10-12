package documentView.views;

import documentView.models.*;
import documentView.types.Status;

public class BoardView {
    void write(Game game){
        System.out.println(game.getBoard());
    }

    void welcomeMessage(Game game){
        double coinflip = Math.random();
        int firstPlayer;

        if (coinflip < 0.5){
            firstPlayer = 0;
        }else{
            firstPlayer = 1;
        }

        Player[] players = game.getPlayers();

        players[firstPlayer].setStatus(Status.MAKING_MOVE);
        game.setPlayers(players);

        System.out.println("Happy Connect4 game! And may the odds be ever in your favor.");
        System.out.println("Congratulations " + players[firstPlayer].getName() + " you will go first");

        write(game);
    }
}
