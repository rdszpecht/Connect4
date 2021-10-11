package DMBasic;

public class Size {
    private int height, width;

    protected Size(int height, int width) {
        this.height = height;
        this.width = width;
    }

    protected int getHeight() {
        return height;
    }

    protected int getWidth() {
        return width;
    }
}
