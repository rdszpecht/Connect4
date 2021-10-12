package DMBasic;

import java.util.Scanner;

public class Connect4 {

    private static final Size BOARD_SIZE = new Size(6,7);
    private static final int NUM_PLAYERS = 2;
    private static final Color[] colors = {Color.YELLOW, Color.RED};
    private final Player[] players;
    private final Board board;
    private final Scanner scanner;
    private GameState gameState;

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
        int lastMove;

        newGame();

        while(gameState == GameState.RESUME){
            for (Player player: players) {
                if (player.getStatus() == Status.MAKING_MOVE) {
                    lastMove = makeMove(player);
                    System.out.println(board);
                    player.setStatus(Status.WAITING);

                    isWiningCondition(player, lastMove);
                }else {
                    player.setStatus(Status.MAKING_MOVE);
                }
                isDraw();
            }
        }

        endGame();
    }

    private void isWiningCondition(Player player, int lastMoveColumn){
        int[][] vectors = {{1,0},{0,1},{1,1},{1,-1}};
        int[][] repositions = {{-4,0},{0,-4},{-4,-4},{-4,4}};
        int[] currentPosition = new int[2];
        int[] nextPosition = new int[2];
        int connected;

        for (int i = 0; i < 4; i++){
            connected = 0;
            currentPosition[0] = (board.getHeightFromColumn(lastMoveColumn) - 1) + repositions[i][0];
            currentPosition[1] = lastMoveColumn + repositions[i][1];

            for (int j = 1; j < 7; j++){
                nextPosition[0] = currentPosition[0] + vectors[i][0];
                nextPosition[1] = currentPosition[1] + vectors[i][1];

                if((board.colorAt(currentPosition[0], currentPosition[1]) == board.colorAt(nextPosition[0], nextPosition[1]))
                        && (board.colorAt(currentPosition[0], currentPosition[1]) != Color.EMPTY)){

                    connected++;
                }
                currentPosition = nextPosition.clone();
            }

            if (connected >= 3){
                player.setStatus(Status.VICTORY);
                for (int k = 0; k < 2; k++){
                    if (players[k].getStatus() != Status.VICTORY){
                        players[k].setStatus(Status.DEFEAT);
                    }
                }
                gameState = GameState.END_BY_VICTORY;
            }
        }
    }

    private void isDraw(){
        if (board.isFull()) {
            for(Player player: players) {
                player.setStatus(Status.DRAW);
            }
            gameState = GameState.END_BY_DRAW;
        }
    }

    private int makeMove(Player player){
        System.out.println(player.getName() + " it's your move, select a column to place a chip");
        int column = -1;
        while(column == -1) {
            try {
                column = Integer.parseInt(scanner.nextLine());
                if (board.isAvailableMove(column)){
                    board.makeMove(column, player.getColor());
                }else{
                    System.out.println("Wrong Column chosen, try again!");
                    column = -1;
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Wrong Integer, try again!");
            } catch (NumberFormatException exception) {
                System.out.println("Not an Integer, try again!");
            }
        }
        return column;
    }

    private void newGame(){
        double coinflip = Math.random();
        int firstPlayer;

        if (coinflip < 0.5){
            firstPlayer = 0;
        }else{
            firstPlayer = 1;
        }

        players[firstPlayer].setStatus(Status.MAKING_MOVE);

        System.out.println("Happy Connect4 game! And may the odds be ever in your favor.");
        System.out.println("Congratulations " + players[firstPlayer].getName() + " you will go first");
        System.out.println(board);
    }

    private void endGame(){
        System.out.println("The game has concluded!");
        switch (players[0].getStatus()) {
            case DRAW -> System.out.println("Congratulations to both players, is a draw!");
            case VICTORY -> System.out.println("Congratulations " + players[0].getName() + ", you win!");
            case DEFEAT -> System.out.println("Congratulations " + players[1].getName() + ", you win!");
        }
    }

}
