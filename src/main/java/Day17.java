import Objects.Day17.GridFrame;
import Objects.Day17.Map;
import Utils.FileReader;
import org.javatuples.Pair;

import java.util.Arrays;

public class Day17 {
    public static void partOne() {
        final Map map = new Map(new FileReader("src/main/resources/Day17Input.txt"), false);
        map.printCount(process(map));
    }

    public static void partTwo() {
        final Map map = new Map(new FileReader("src/main/resources/Day17Input.txt"), true);
        map.printCountPart2(process(map));
    }

    private static char[][] process(final Map map) {
        try {
            final char[][] mapInstance = map.createMap();
            final GridFrame frame = new GridFrame(mapInstance);
            frame.setVisible(true);
            final char[][] completedMap = map.drip(mapInstance, new Pair<>(map.getSpringPosition(mapInstance), 1), frame);
            frame.revalidate();
            frame.repaint();
            return completedMap;
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
