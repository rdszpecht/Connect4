package documentView.views;

import documentView.models.Game;

abstract class WithGameView {
    protected Game game;

    WithGameView(Game game){
        this.game = game;
    }
}
