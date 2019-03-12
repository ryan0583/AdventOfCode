package Objects;

import java.util.Arrays;

public class GridToPrint {
    private int yDist;
    private int numSeconds;
    private String[][] grid;

    public GridToPrint(int yDist, int numSeconds, String[][] grid) {
        this.yDist = yDist;
        this.numSeconds = numSeconds;
        this.grid = grid;
    }

    public void printGrid() {
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
        System.out.println("Day Ten, Part Two:");
        System.out.println(numSeconds);
    }

    public int getyDist() {
        return yDist;
    }

    public void setyDist(int yDist) {
        this.yDist = yDist;
    }

    public int getNumSeconds() {
        return numSeconds;
    }

    public void setNumSeconds(int numSeconds) {
        this.numSeconds = numSeconds;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }
}
