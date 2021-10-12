package documentView.models;

import documentView.types.Color;
import documentView.types.GameState;
import documentView.types.Size;
import documentView.types.Status;

public class Game {
    private static final Size BOARD_SIZE = new Size(6,7);
    private static final int NUM_PLAYERS = 2;
    private static final Color[] colors = {Color.YELLOW, Color.RED};
    private Player[] players;
    private final Board board;
    private GameState gameState;



    private int lastMoveColumn;

    public Game(){
        this.board = new Board(BOARD_SIZE);
        this.players = new Player[NUM_PLAYERS];
        for (int i = 0; i < NUM_PLAYERS; i++){
            this.players[i] = new Player(colors[i], Status.WAITING);
        }
        this.gameState = GameState.RESUME;
    }

    public void next(){
        for (Player player: players){
            if (player.getStatus() == Status.MAKING_MOVE){
                player.setStatus(Status.WAITING);
            }else{
                player.setStatus(Status.MAKING_MOVE);
            }
        }
    }

    public boolean isWiningCondition(){
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
                Color lastColor = board.getLastColor(lastMoveColumn);
                for (Player player: players){
                    if (player.getColor() == lastColor){
                        player.setStatus(Status.VICTORY);
                    }else{
                        player.setStatus(Status.DEFEAT);
                    }
                }
                gameState = GameState.END_BY_VICTORY;

                return true;
            }
        }
        return false;
    }

    public boolean isDraw(){
        if (board.isFull()) {
            for (Player player: players) {
                player.setStatus(Status.DRAW);
            }
            gameState = GameState.END_BY_DRAW;

            return true;
        }
        return false;
    }

    public GameState getGameState(){
        return this.gameState;
    }

    public Player getWinner(){
        if (players[0].getStatus() == Status.VICTORY){
            return players[0];
        }else{
            return players[1];
        }
    }

    public boolean isResumed(){
        return (this.gameState == gameState.RESUME);
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players){
        this.players = players.clone();
    }

    public void setLastMoveColumn(int lastMoveColumn) {
        this.lastMoveColumn = lastMoveColumn;
    }
}

