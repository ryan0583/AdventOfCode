package Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridToPrint {
    private int numSeconds;
    private List<Star> stars = new ArrayList<>();
    private int minX = Integer.MIN_VALUE / 2;
    private int maxX = Integer.MAX_VALUE / 2;
    private int minY = Integer.MIN_VALUE / 2;
    private int maxY = Integer.MAX_VALUE / 2;

    public GridToPrint() {
    }

    public GridToPrint(int numSeconds, List<Star> stars, int minX, int maxX, int minY, int maxY) {
        this.numSeconds = numSeconds;
        this.stars = stars
                .stream()
                .map(star -> new Star(star.getxPosition(), star.getyPosition(), 0, 0))
                .collect(Collectors.toList());
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public void printGrid() {
        String[][] grid = new String[maxY - minY + 1][maxX - minX + 1];
        for (String[] row : grid) {
            Arrays.fill(row, ".");
        }

        for (Star star : stars) {
            grid[star.getyPosition() - minY][star.getxPosition() - minX] = "#";
        }
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
        System.out.println("Day Ten, Part Two:");
        System.out.println(numSeconds);
    }

    public int getyDist() {
        return maxY - minY;
    }
}
