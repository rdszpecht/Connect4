package presentationModel.controllers;

import presentationModel.models.Game;

public abstract class Controller {
    protected Game game;

    Controller(Game game){
        this.game = game;
    }

    public String getBoardString(){
        return game.getBoard().toString();
    }

}
