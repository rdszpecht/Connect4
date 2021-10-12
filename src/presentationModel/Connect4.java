package presentationModel;

import presentationModel.controllers.PlayController;
import presentationModel.controllers.ResumeController;
import presentationModel.controllers.StartController;
import presentationModel.models.Game;
import presentationModel.views.View;

public class Connect4 {

    private Game game;
    private View view;
    protected PlayController playController;
    protected StartController startController;
    protected ResumeController resumeController;

    public Connect4(){
        this.game = new Game();
        this.playController = new PlayController(this.game);
        this.startController = new StartController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView();
    }

    protected View createView(){
        return new View(this.startController, this.resumeController, this.playController);
    }

    public static void main(String[] args){
        new Connect4().play();
    }

    private void play(){
        do{
            this.view.start();
            this.view.play();
        }while(this.view.resume());
    }
}
