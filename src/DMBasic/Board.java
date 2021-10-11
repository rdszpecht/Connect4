package DMBasic;

public class Board {

    private Column[] columns;
    private int rows;

    protected Board(Size size){
        this.rows = size.getHeight();
        this.columns = new Column[size.getWidth()];
        for (int i = 0; i < size.getWidth(); i++) {
            this.columns[i] = new Column(size.getHeight());
        }
    }

    protected boolean makeMove(int column, Color color){
        return this.columns[column].makeMove(color);
    }

    protected boolean isFull(){
        int i = 0;

        while(i < columns.length && !(columns[i].isFull())){
            i++;
        }

        if (i == columns.length && columns[i-1].isFull()){
            return true;
        }
        return false;
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
