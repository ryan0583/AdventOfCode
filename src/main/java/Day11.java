import Objects.Day11.Result;

import java.util.ArrayList;
import java.util.List;

public class Day11 {

    public static void partOne() {
        System.out.println("Day Eleven, Part One:");

        int gridSerialNumber = 6042;

        int[][] grid = generateGrid(gridSerialNumber);

        getMaxResult(grid, 3).print();
    }

    public static void partTwo() {
        System.out.println("Day Eleven, Part Two:");

        int gridSerialNumber = 6042;

        int[][] grid = generateGrid(gridSerialNumber);

        List<Integer> squareSizes = new ArrayList<>();

        for (int val = 0; val < 299; val++) {
            squareSizes.add(val + 1);
        }

        squareSizes.parallelStream()
                .map(squareSize -> getMaxResult(grid, squareSize))
                .reduce(null, (currentResult, result) -> currentResult == null ||
                        result.getTotalPower() > currentResult.getTotalPower() ? result : currentResult)
                .print();
    }

    private static Result getMaxResult(int[][] grid, int squareSize) {
        System.out.print("-");

        int maxPower = Integer.MIN_VALUE;
        Result result = null;

        for (int y = 0; y < 300 - squareSize; y++) {
            for (int x = 0; x < 300 - squareSize; x++) {
                int totalPower = getTotalPower(grid, y, x, squareSize);
                if (totalPower > maxPower) {
                    maxPower = totalPower;
                    result = new Result(totalPower, y + 1, x + 1, squareSize);
                }
            }
        }

        return result;
    }

    private static int[][] generateGrid(int gridSerialNumber) {
        int[][] grid = new int[300][300];

        for (int y = 0; y < 300; y++) {
            for (int x = 0; x < 300; x++) {
                int xcoord = x + 1;
                int ycoord = y + 1;

                int rackId = xcoord + 10;

                int powerLevel = rackId * ycoord;
                powerLevel += gridSerialNumber;
                powerLevel *= rackId;
                powerLevel = (powerLevel % 1000 - powerLevel % 100) / 100;
                powerLevel -= 5;

                grid[y][x] = powerLevel;
            }
        }

        return grid;
    }

    private static int getTotalPower(int[][] grid, int startY, int startX, int squareSize) {
        int totalPower = 0;

        for (int y = startY; y < startY + squareSize; y++) {
            for (int x = startX; x < startX + squareSize; x++) {
                totalPower += grid[y][x];
            }
        }

        return totalPower;
    }
}
