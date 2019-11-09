package Objects.Day17;

import Utils.FileReader;
import org.javatuples.Pair;
import org.junit.Test;

import java.util.Arrays;

public class MapIntegrationTest {

    final FileReader fileReader = new FileReader("src/main/resources/Day17TestInput.txt");

    final Map map = new Map(fileReader, false);

    @Test
    public void generatesExpectedMap() {
        final char[][] mapInstance = map.createMap();
        System.out.println(Arrays.deepToString(mapInstance).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
    }

    @Test
    public void drip() {
        final char[][] mapInstance = map.createMap();
        final char[][] drippedMap = map.drip(mapInstance, new Pair<>(map.getSpringPosition(mapInstance), 1), null);
        System.out.println(Arrays.deepToString(drippedMap).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
    }
}
