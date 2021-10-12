package DMBasic;

import java.util.Stack;

public class Column {

    private Stack<Color> colors;
    private int maxHeight;

    protected Column(int maxHeight){
        this.colors = new Stack<Color>();
        this.maxHeight = maxHeight;
    }

    protected boolean makeMove(Color color){
        if (colors.size() < maxHeight) {
            return colors.add(color);
        }else{
            return false;
        }
    }

    protected Color colorAt(int y){
        if (colors.size() > y) {
            return colors.elementAt(y);
        }else{
            return Color.EMPTY;
        }
    }

    protected String printColorFromPositionY(int y){
        try{
            return colors.elementAt(y).toString();
        }catch(ArrayIndexOutOfBoundsException ex){
            return " . ";
        }
    }

    protected boolean isFull(){
        if (this.colors.size() >= maxHeight){
            return true;
        }
        return false;
    }

    protected int getHeight(){
        return colors.size();
    }
}
