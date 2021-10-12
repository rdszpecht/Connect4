package DMBasic;

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

    protected String getName(){
        return this.name;
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
