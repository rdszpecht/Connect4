package presentationModel.views;


import presentationModel.controllers.*;

import java.util.Scanner;

public class PlayerView {

    private PlayController playController;
    private Scanner scanner = new Scanner(System.in);

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact(){
        System.out.println("Select a column to place a chip");
        playController.makeMove();
    }
}
