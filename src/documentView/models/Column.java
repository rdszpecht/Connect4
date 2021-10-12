package documentView.models;

import documentView.types.*;

import java.util.Stack;

public class Column {

    private Stack<Color> colors;
    private int maxHeight;

    public Column(int maxHeight){
        this.colors = new Stack<Color>();
        this.maxHeight = maxHeight;
    }

    public boolean makeMove(Color color){
        if (colors.size() < maxHeight) {
            return colors.add(color);
        }else{
            return false;
        }
    }

    public Color colorAt(int y){
        if (colors.size() > y) {
            return colors.elementAt(y);
        }else{
            return Color.EMPTY;
        }
    }

    public String printColorFromPositionY(int y){
        try{
            return colors.elementAt(y).toString();
        }catch(ArrayIndexOutOfBoundsException ex){
            return " . ";
        }
    }

    public Color getLastColor(){
        return colors.lastElement();
    }

    public boolean isFull(){
        if (this.colors.size() >= maxHeight){
            return true;
        }
        return false;
    }

    public int getHeight(){
        return colors.size();
    }
}
