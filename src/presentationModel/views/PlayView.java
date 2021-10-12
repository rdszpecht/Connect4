package presentationModel.views;

import presentationModel.types.GameState;
import presentationModel.controllers.*;

public class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().write(this.playController);
        } while (!this.playController.isWiningCondition() && !this.playController.isDraw());

        if (this.playController.getGameState() == GameState.END_BY_DRAW){
            System.out.println("Congratulations, is a Draw!");
        }else {
            System.out.println("Player " + this.playController.getWinner().getName() + " Wins!");
        }
    }
}
