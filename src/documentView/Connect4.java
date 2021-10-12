package documentView;

import documentView.models.*;
import documentView.views.*;

public class Connect4 {

    private Game game;
    private View view;

    public Connect4(){
        this.game = new Game();
        this.view = new View(this.game);
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
