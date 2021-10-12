package documentView.views;

import documentView.models.Game;
import documentView.types.GameState;

public class PlayView extends WithGameView{

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isWiningCondition() && !this.game.isDraw());

        if (this.game.getGameState() == GameState.END_BY_DRAW){
            System.out.println("Congratulations, is a Draw!");
        }else {
            System.out.println("Player " + this.game.getWinner().getName() + " Wins!");
        }
    }
}
