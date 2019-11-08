import Objects.Day17.Map;
import Utils.FileReader;
import org.javatuples.Pair;

import java.util.Arrays;

public class Day17 {
    public static void partOne() {
        final Map map = new Map(new FileReader("src/main/resources/Day17Input.txt"));
        final char[][] mapInstance = map.createMap();
        final char[][] completedMap = map.drip(mapInstance, new Pair<>(map.getSpringPosition(mapInstance), 1));
        System.out.println(Arrays.deepToString(mapInstance).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
        map.printCount(completedMap);
    }
}
