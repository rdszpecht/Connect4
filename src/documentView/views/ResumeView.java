package documentView.views;

import documentView.models.Game;
public class ResumeView extends WithGameView{

    ResumeView(Game game) {
        super(game);
    }
    boolean interact() {
        return this.game.isResumed();
    }
}
