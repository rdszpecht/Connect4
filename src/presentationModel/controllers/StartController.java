package presentationModel.controllers;

import presentationModel.models.*;
import presentationModel.types.Status;

public class StartController extends Controller{

    private Game game;
    private Player firstPlayer;

    public StartController(Game game) {
        super(game);
        this.game = game;
    }

    public void start() {
        double coinflip = Math.random();
        int firstPlayer;

        if (coinflip < 0.5) {
            firstPlayer = 0;
        } else {
            firstPlayer = 1;
        }

        Player[] players = game.getPlayers();

        players[firstPlayer].setStatus(Status.MAKING_MOVE);
        game.setPlayers(players);
        this.firstPlayer = players[firstPlayer];
    }

    public String getFirstPlayerName() {
        return this.firstPlayer.getName();
    }
}
