package pro.puradawid.constructor;

public class DataStructureParametersCuboid {

    private final Dimension dimension;
    private final Colour colour;


    DataStructureParametersCuboid(Dimension dimension, Colour colour) {
        this.dimension = dimension;
        this.colour = colour;
    }

    double volume() {
        return dimension.getDepth() * dimension.getHeight() * dimension.getWidth();
    }

    public static class Dimension {

        private final double width;
        private final double height;
        private final double depth;

        Dimension(double width, double height, double depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double getDepth() {
            return depth;
        }
    }

    public static class Colour {

        private final int r;
        private final int g;
        private final int b;


        Colour(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }
    }
}

