package documentView.views;

import documentView.models.Game;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        BoardView boardView = new BoardView();
        boardView.welcomeMessage(this.game);
        boardView.write(this.game);
    }

}
