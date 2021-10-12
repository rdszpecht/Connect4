package presentationModel.models;

import presentationModel.types.Color;
import presentationModel.types.Size;

public class Board {

    private Column[] columns;
    private int rows;

    public Board(Size size){
        this.rows = size.getHeight();
        this.columns = new Column[size.getWidth()];
        for (int i = 0; i < size.getWidth(); i++) {
            this.columns[i] = new Column(size.getHeight());
        }
    }

    public boolean isAvailableMove(int column) {
        return !(columns[column].isFull());
    }

    public boolean makeMove(int column, Color color){
        return columns[column].makeMove(color);
    }

    public Color colorAt(int y, int x){
        if (x >= 0 && y >= 0 && x < columns.length && y < rows) {
            return columns[x].colorAt(y);
        }else{
            return Color.EMPTY;
        }
    }

    public Color getLastColor(int col){
        return columns[col].getLastColor();
    }

    public boolean isFull(){
        int i = 0;

        while(i < columns.length && columns[i].isFull()){
            i++;
        }

        if (i == columns.length && columns[i-1].isFull()){
            return true;
        }
        return false;
    }

    public int getHeightFromColumn(int column){
        return columns[column].getHeight();
    }

    @Override
    public String toString() {
        String toPrint = "";
        for(int i = rows - 1; i >= 0; i--){
            toPrint += i + "|";
            for(int j = 0; j < columns.length; j++){
                toPrint += columns[j].printColorFromPositionY(i);
            }
            toPrint += "\n";
        }
        toPrint += "________________________\n";
        toPrint += "   0  1  2  3  4  5  6";
        return toPrint;
    }

}
