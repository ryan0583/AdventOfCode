package Objects.Day17;

import Utils.FileReader;
import lombok.AllArgsConstructor;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class Map {

    public static final char SAND = '.';
    public static final char CLAY = '#';
    public static final char SPRING = '+';
    public static final char DRIP = '|';
    public static final char WATER = '~';

    private FileReader fileReader;
    private Boolean incrementalDraw;

    public char[][] createMap() {
        final List<Clay> clays = getClayPositions();
        final List<Integer> xPositions = clays.stream().map(Clay::getX).collect(Collectors.toList());
        final int xRange = Collections.max(xPositions) - Collections.min(xPositions);
        return addClay(
                addSpring(
                        createEmptyMap(
                                clays.stream().map(Clay::getY).max(Integer::compareTo).get() + 1,
                                xRange + 3),
                        clays),
                normaliseClayPositions(clays));
    }

    public int getSpringPosition(final char[][] map) {
        return new String(map[0]).indexOf(SPRING);
    }

    public char[][] drip(final char[][] map, final Pair<Integer, Integer> coords, final GridFrame frame) throws InterruptedException {
        Pair<Integer, Integer> nextCoords = doDripping(map, coords);

        draw(frame);

        if (nextCoords.getValue0() < map[0].length
                && nextCoords.getValue1() < map.length) {
            final Pair<Integer, Integer> top = fill(map, nextCoords);
            draw(frame);
            if (map[moveDown(top).getValue1()][top.getValue0()] == WATER) {
                map[top.getValue1()][top.getValue0()] = DRIP;
            }
            dripNext(map, top, frame);
        }

        return map;
    }

    private Pair<Integer, Integer> doDripping(final char[][] map, final Pair<Integer, Integer> coords) {
        Pair<Integer, Integer> nextCoords = coords;
        while (nextCoords.getValue0() < map[0].length
                && nextCoords.getValue1() < map.length
                && map[nextCoords.getValue1()][nextCoords.getValue0()] == SAND) {
            map[nextCoords.getValue1()][nextCoords.getValue0()] = DRIP;
            nextCoords = moveDown(nextCoords);
        }
        return nextCoords;
    }

    private void draw(final GridFrame frame) throws InterruptedException {
        if (incrementalDraw) {
            frame.revalidate();
            frame.repaint();
            Thread.sleep(100);
        }
    }

    private void dripNext(final char[][] map, final Pair<Integer, Integer> coords, final GridFrame frame) throws InterruptedException {
        //System.out.println(Arrays.deepToString(map).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
        //System.out.println("\r\n");
        dripNextRight(map, coords, frame);
        dripNextLeft(map, coords, frame);

    }

    private void dripNextRight(final char[][] map, final Pair<Integer, Integer> coords, final GridFrame frame) throws InterruptedException {
        Pair<Integer, Integer> topRight = moveRight(coords);
        while (topRight.getValue0() < map[0].length
                && map[topRight.getValue1()][topRight.getValue0()] == DRIP) {
            topRight = moveRight(topRight);
        }
        if (topRight.getValue0() < map[0].length
                && topRight.getValue1() > 0
                && shouldDripRight(map, topRight)) {
            //System.out.println("DRIP RIGHT!!");
            drip(map, topRight, frame);
        }
    }

    private void dripNextLeft(final char[][] map, final Pair<Integer, Integer> coords, final GridFrame frame) throws InterruptedException {
        Pair<Integer, Integer> topLeft = moveLeft(coords);
        while (topLeft.getValue0() < map[0].length
                && map[topLeft.getValue1()][topLeft.getValue0()] == DRIP) {
            topLeft = moveLeft(topLeft);
        }
        if (topLeft.getValue0() > 0
                && topLeft.getValue1() > 0
                && shouldDripLeft(map, topLeft)) {
            //System.out.println("DRIP LEFT!!");
            drip(map, topLeft, frame);
        }
    }

    private boolean shouldDripRight(final char[][] map, final Pair<Integer, Integer> coords) {
        final Pair<Integer, Integer> left = moveLeft(coords);
        final Pair<Integer, Integer> downAndLeft = moveDown(left);

        final char thisChar = map[coords.getValue1()][coords.getValue0()];
        final char charLeft = map[left.getValue1()][left.getValue0()];
        final char charDownLeft = map[downAndLeft.getValue1()][downAndLeft.getValue0()];
        return thisChar == SAND &&
                (charLeft == DRIP || charLeft == CLAY) && (
                charDownLeft == CLAY
                        || charDownLeft == WATER);
    }

    private boolean shouldDripLeft(final char[][] map, final Pair<Integer, Integer> coords) {
        final Pair<Integer, Integer> right = moveRight(coords);
        final Pair<Integer, Integer> downAndRight = moveDown(right);

        final char thisChar = map[coords.getValue1()][coords.getValue0()];
        final char charRight = map[right.getValue1()][right.getValue0()];
        final char charDownRight = map[downAndRight.getValue1()][downAndRight.getValue0()];
        return thisChar == SAND &&
                (charRight == DRIP || charRight == CLAY) && (
                charDownRight == CLAY
                        || charDownRight == WATER);
    }

    public void printCount(final char[][] map) {
        int count = 0;
        final int minY = findMinY(map);
        for (int i = minY; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == DRIP || map[i][j] == WATER) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private int findMinY(final char[][] map) {
        for (int i = 0; i < map.length; i++) {
            final char[] row = map[i];
            if (new String(row).contains("" + CLAY)) {
                return i;
            }
        }
        return 0;
    }

    public void printCountPart2(final char[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == WATER) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private Pair<Integer, Integer> moveDown(final Pair<Integer, Integer> coords) {
        return new Pair<>(coords.getValue0(), coords.getValue1() + 1);
    }

    private Pair<Integer, Integer> moveUp(final Pair<Integer, Integer> coords) {
        return new Pair<>(coords.getValue0(), coords.getValue1() - 1);
    }

    private Pair<Integer, Integer> moveLeft(final Pair<Integer, Integer> coords) {
        return new Pair<>(coords.getValue0() - 1, coords.getValue1());
    }

    private Pair<Integer, Integer> moveRight(final Pair<Integer, Integer> coords) {
        return new Pair<>(coords.getValue0() + 1, coords.getValue1());
    }

    private Pair<Integer, Integer> fill(final char[][] map, final Pair<Integer, Integer> nextCoords) {
        final Pair<Integer, Integer> bottomRow = moveUp(nextCoords);
        Pair<Integer, Integer> top = bottomRow;
        final Integer leftEdge = findContainerLeftEdge(map, nextCoords);
        final Integer rightEdge = findContainerRightEdge(map, nextCoords);
        if (leftEdge != null && rightEdge != null) {
            top = fillRow(map, bottomRow, leftEdge, rightEdge);
        }
        return top;
    }

    private Pair<Integer, Integer> fillRow(final char[][] map, final Pair<Integer, Integer> coords, final int min, final int max) {
        map[coords.getValue1()][coords.getValue0()] = WATER;
        final int newMax = fillRight(map, coords, max);
        final int newMin = fillLeft(map, coords, min);
        final Pair<Integer, Integer> nextCoords = moveUp(coords);
        if (map[nextCoords.getValue1()][max] == CLAY
                && map[nextCoords.getValue1()][min] == CLAY) {
            return fillRow(map, nextCoords, newMin, newMax);
        }
        return nextCoords;
    }

    private int fillRight(final char[][] map, final Pair<Integer, Integer> coords, final int max) {
        Pair<Integer, Integer> nextCoords = moveRight(coords);
        char nextChar = map[nextCoords.getValue1()][nextCoords.getValue0()];
        while ((nextChar == SAND || nextChar == DRIP)
                && nextCoords.getValue0() < max) {
            map[nextCoords.getValue1()][nextCoords.getValue0()] = WATER;
            nextCoords = moveRight(nextCoords);
            nextChar = map[nextCoords.getValue1()][nextCoords.getValue0()];
        }
        return nextCoords.getValue0();
    }

    private int fillLeft(final char[][] map, final Pair<Integer, Integer> coords, final int min) {
        Pair<Integer, Integer> nextCoords = moveLeft(coords);
        char nextChar = map[nextCoords.getValue1()][nextCoords.getValue0()];
        while ((nextChar == SAND || nextChar == DRIP)
                && nextCoords.getValue0() > min) {
            map[nextCoords.getValue1()][nextCoords.getValue0()] = WATER;
            nextCoords = moveLeft(nextCoords);
            nextChar = map[nextCoords.getValue1()][nextCoords.getValue0()];
        }
        return nextCoords.getValue0();
    }

    private Integer findContainerRightEdge(final char[][] map, final Pair<Integer, Integer> coords) {
        Integer edge = null;
        Pair<Integer, Integer> nextCoords = coords;
        char c = map[nextCoords.getValue1()][nextCoords.getValue0()];
        while (c == CLAY || c == WATER) {
            nextCoords = moveRight(nextCoords);
            final char charAbove = map[nextCoords.getValue1() - 1][nextCoords.getValue0()];
            if (charAbove == CLAY) {
                edge = nextCoords.getValue0();
                break;
            }
            c = map[nextCoords.getValue1()][nextCoords.getValue0()];
        }
        return edge;
    }

    private Integer findContainerLeftEdge(final char[][] map, final Pair<Integer, Integer> coords) {
        Integer edge = null;
        Pair<Integer, Integer> nextCoords = coords;
        char c = map[nextCoords.getValue1()][nextCoords.getValue0()];
        while (c == CLAY || c == WATER) {
            nextCoords = moveLeft(nextCoords);
            final char charAbove = map[nextCoords.getValue1() - 1][nextCoords.getValue0()];
            if (charAbove == CLAY) {
                edge = nextCoords.getValue0();
                break;
            }
            c = map[nextCoords.getValue1()][nextCoords.getValue0()];
        }
        return edge;
    }

    public char[][] createEmptyMap(final int ySize, final int xSize) {
        final char[][] map = new char[ySize][xSize];
        Arrays.stream(map)
                .forEach(row -> Arrays.fill(row, SAND));
        return map;
    }

    public List<Clay> getClayPositions() {
        return fileReader.readFile()
                .stream()
                .flatMap(this::extractRange)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    public List<Clay> normaliseClayPositions(final List<Clay> clays) {
        final int minX = clays.stream()
                .map(Clay::getX)
                .min(Integer::compareTo)
                .get();

        return clays.stream()
                .map(clay -> new Clay(clay.getX() - minX + 1, clay.getY()))
                .collect(Collectors.toList());
    }

    public char[][] addClay(final char[][] map, final List<Clay> clays) {
        clays.forEach(clay -> map[clay.getY()][clay.getX()] = CLAY);
        return map;
    }

    private char[][] addSpring(final char[][] map, final List<Clay> clays) {
        map[0][501 - clays.stream().map(Clay::getX).min(Integer::compareTo).get()] = SPRING;
        return map;
    }

    private Stream<String> extractRange(final String pos) {
        if (!pos.contains("..")) {
            return List.of(pos).stream();
        }

        final String[] posArr = pos.split(", ");
        final List<String> pos0Arr = extractPositionArray(posArr[0]);
        final List<String> pos1Arr = extractPositionArray(posArr[1]);

        return pos0Arr.stream()
                .flatMap(pos0
                        -> pos1Arr.stream().map(pos1 -> pos0 + ", " + pos1));
    }

    private List<String> extractPositionArray(final String pos) {
        final List<String> posList = new ArrayList<>();
        if (!pos.contains("..")) {
            posList.add(pos);
        } else {
            final String[] split = pos.split("=");
            final String xOrY = split[0];
            final String[] rangeVals = split[1].split("\\.\\.");
            for (int i = Integer.parseInt(rangeVals[0]); i < Integer.parseInt(rangeVals[1]) + 1; i++) {
                posList.add(xOrY + "=" + i);
            }
        }
        return posList;
    }

    private Clay parseLine(final String line) {
        final Clay clay = new Clay();
        Arrays.stream(line.split(", "))
                .forEach(pos -> parsePosition(clay, pos));

        return clay;
    }

    private void parsePosition(final Clay clay, final String pos) {
        final String[] posArr = pos.split("=");
        final String xOrY = posArr[0];
        final int value = Integer.parseInt(posArr[1]);
        if (xOrY.equals("x")) {
            clay.setX(value);
        } else {
            clay.setY(value);
        }
    }
}
