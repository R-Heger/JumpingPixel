package graphics;

public class DrawInfo {
    private int[] position;
    private int[][][] graphicalPattern;

    public DrawInfo(int[] position, int[][][] graphicalPattern) {
        this.position = position;
        this.graphicalPattern = graphicalPattern;
    }

    public int[] getPosition() {
        return position;
    }

    public int[][][] getGraphicalPattern() {
        return graphicalPattern;
    }
}
