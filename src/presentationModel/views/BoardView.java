package presentationModel.views;

import presentationModel.controllers.*;

public class BoardView {

    void write(Controller controller){
        System.out.println(controller.getBoardString());
    }

    void welcomeMessage(StartController controller){

        System.out.println("Happy Connect4 game! And may the odds be ever in your favor.");
        System.out.println("Congratulations " + controller.getFirstPlayerName() + " you will go first");

        System.out.println(controller.getBoardString());
    }
}
