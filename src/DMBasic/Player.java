package DMBasic;

public class Player {
    private Color color;
    private Status status;

    public Player(Color color, Status status) {
        this.color = color;
        this.status = status;
    }

    protected String getName(){
        if (this.color == Color.RED){
            return "Red Player";
        }else{
            return "Yellow Player";
        }
    }

    protected Color getColor(){
        return this.color;
    }

    protected Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }
}
