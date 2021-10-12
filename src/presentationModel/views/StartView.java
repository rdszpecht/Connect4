package presentationModel.views;

import presentationModel.controllers.StartController;

class StartView {

    StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        startController.start();
        BoardView boardView = new BoardView();
        boardView.welcomeMessage(this.startController);
        boardView.write(this.startController);
    }

}
