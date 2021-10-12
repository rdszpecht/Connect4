package presentationModel.controllers;

import presentationModel.models.Game;

public class ResumeController extends Controller {
    private Game game;

    public ResumeController(Game game) {
        super(game);
        this.game = game;
    }

    public boolean isResumed(){
        return this.game.isResumed();
    }
}
