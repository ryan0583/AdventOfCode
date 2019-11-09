import Objects.Day17.GridFrame;
import Objects.Day17.Map;
import Utils.FileReader;
import org.javatuples.Pair;

import java.util.Arrays;

public class Day17 {
    public static void partOne() {
        final Map map = new Map(new FileReader("src/main/resources/Day17Input.txt"));
        map.printCount(process(map));
    }

    public static void partTwo() {
        final Map map = new Map(new FileReader("src/main/resources/Day17Input.txt"));
        map.printCountPart2(process(map));
    }

    private static char[][] process(final Map map) {
        final char[][] mapInstance = map.createMap();
        final char[][] completedMap = map.drip(mapInstance, new Pair<>(map.getSpringPosition(mapInstance), 1));
//        System.out.println(Arrays.deepToString(mapInstance).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
        GridFrame frame = new GridFrame(completedMap);
        frame.setVisible(true);
        return completedMap;
    }
}
