package documentView.models;

import documentView.types.*;

public class Player {
    private Color color;
    private Status status;
    private final String name;

    public Player(Color color, Status status) {
        this.color = color;
        this.status = status;

        if (this.color == Color.RED){
            this.name = "Red Player";
        }else{
            this.name = "Yellow Player";
        }
    }

    public String getName(){
        return this.name;
    }

    public Color getColor(){
        return this.color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
