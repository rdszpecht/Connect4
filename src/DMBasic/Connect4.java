package DMBasic;

import java.util.Scanner;

public class Connect4 {

    private static final Size BOARD_SIZE = new Size(6,7);
    private static final int NUM_PLAYERS = 2;
    private static final Color[] colors = {Color.YELLOW, Color.RED};
    private GameState gameState;
    private Player[] players;
    private Board board;
    private Scanner scanner;

    protected Connect4(){
        this.board = new Board(BOARD_SIZE);
        this.players = new Player[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++){
            this.players[i] = new Player(colors[i], Status.WAITING);
        }
        this.gameState = GameState.RESUME;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args){
        new Connect4().playGame();
    }

    private void playGame(){
        newGame();
        System.out.println(board);

        while(gameState == GameState.RESUME){
            for (Player player: players) {
                if (player.getStatus() == Status.MAKING_MOVE) {
                    makeMove(player);
                    System.out.println(board);
                    player.setStatus(Status.WAITING);
                }else {
                    player.setStatus(Status.MAKING_MOVE);
                }
                isWiningCondition(player);
                isDraw(player);
            }
        }
        fixStatuses();
        endGame();
    }

    private void isWiningCondition(Player player){
        if(false) {
            player.setStatus(Status.VICTORY);
            gameState = GameState.END_BY_VICTORY;
        }
    }

    private void isDraw(Player player){
        if (board.isFull()) {
            player.setStatus(Status.DRAW);
            gameState = GameState.END_BY_DRAW;
        }
    }

    private void makeMove(Player player){
        System.out.println(player.getName() + " it's your move, select a column to place a chip");
        try{
            int column = Integer.parseInt(scanner.nextLine());
            if (!board.makeMove(column, player.getColor())){
                makeMove(player);
            }
        }catch(IndexOutOfBoundsException exception){
            System.out.println("Wrong Integer, try again");
            makeMove(player);
        }catch(NumberFormatException exception){
            System.out.println("Not an Integer, try again");
            makeMove(player);
        }
    }

    private void newGame(){
        System.out.println("Happy Connect4 game! And may the odds be ever in your favor.");

        double coinflip = Math.random();
        int firstPlayer;
        if (coinflip < 0.5){
            firstPlayer = 0;
        }else{
            firstPlayer = 1;
        }

        players[firstPlayer].setStatus(Status.MAKING_MOVE);
        System.out.println("Congratulations " + players[firstPlayer].getName() + " you will go first");
    }

    private void endGame(){
        System.out.println("The game has concluded!");
        switch(players[0].getStatus()){
            case DRAW :
                System.out.println("Congratulations to both players, is a draw!");
                break;
            case VICTORY:
                System.out.println("Congratulations " + players[0].getName() + ", you win!");
                break;
            case DEFEAT:
                System.out.println("Congratulations " + players[1].getName() + ", you win!");
                break;
        }
    }

    private void fixStatuses(){
        for (Player player: players) {
            if (player.getStatus() == Status.MAKING_MOVE || player.getStatus() == Status.WAITING){
                if (gameState == GameState.END_BY_VICTORY){
                    player.setStatus(Status.DEFEAT);
                }else{
                    player.setStatus(Status.DRAW);
                }
            }
        }
    }
}
