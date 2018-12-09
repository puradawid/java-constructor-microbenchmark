package pro.puradawid.constructor;

public class PlainParametersCuboid {

    private final double width;
    private final double height;
    private final double depth;

    private final int r;
    private final int g;
    private final int b;

    public PlainParametersCuboid(double width, double height, double depth, int r, int g, int b) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public double volume() {
        return width * height * depth;
    }
}