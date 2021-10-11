package DMBasic;

import java.util.Stack;

public class Column {

    private Stack<Color> colors;
    private int height;

    protected Column(int height){
        this.colors = new Stack<Color>();
        this.height = height;
    }

    protected boolean makeMove(Color color){
        if (colors.size() < height) {
            return colors.add(color);
        }else{
            return false;
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
        if (this.colors.size() >= height){
            return true;
        }
        return false;
    }
}
