package DMBasic;

public enum Color {
    YELLOW, RED;

    @Override
    public String toString() {
        if (this.equals(Color.YELLOW)){
            return " Y ";
        }
        if (this.equals(Color.RED)){
            return " R ";
        }
        return " . ";
    }
}
