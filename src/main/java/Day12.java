import java.util.Arrays;
import java.util.HashMap;

public class Day12 {
    private static String initialState = "#...##.#...#..#.#####.##.#..###.#.#.###....#...#...####.#....##..##..#..#..#..#.#..##.####.#.#.###";

    public static void partOne() {
        System.out.println("Day Twelve, Part One:");
        HashMap<String, Character> patterns = initialisePatternsMap();

        String currentString = initialState;
        long zeroOffset = 0;

        for (long i = 0; i < 20; i++) {
            if (currentString.substring(0, 5).contains("#")) {
                zeroOffset += 5;
                currentString = "....." + currentString;
            }
            if (currentString.substring(currentString.length() - 5).contains("#")) {
                currentString = currentString + ".....";
            }
            currentString = updateString(currentString, patterns);
        }

        System.out.println(calculateScore(currentString, zeroOffset));
    }

    public static void partTwo() {
        System.out.println("Day Twelve, Part Two:");
        String standardStr = "###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###..###";

        System.out.println(calculateScore(standardStr, -50000000000L + 70));
    }

    private static String updateString(String currentString, HashMap<String, Character> patterns) {
        char[] currentChars = currentString.toCharArray();
        char[] newChars = Arrays.copyOf(currentChars, currentChars.length);

        for (String pattern : patterns.keySet()) {
            for (int i = 0; i < currentChars.length - 5; i++) {
                String toMatch = new String(Arrays.copyOfRange(currentChars, i, i + 5));
                if (pattern.equals(toMatch)) {
                    char newChar = patterns.get(pattern);
                    newChars[i + 2] = newChar;
                }
            }
        }

        return new String(newChars);
    }

    private static long calculateScore(String currentString, long zeroOffset) {
        long score = 0;
        char[] chars = currentString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '#') {
                score += i - zeroOffset;
            }
        }
        return score;
    }

    private static HashMap<String, Character> initialisePatternsMap() {
        HashMap<String, Character> patterns = new HashMap<>();
        patterns.put(".....", '.');
        patterns.put("..#..", '#');
        patterns.put("..##.", '#');
        patterns.put("#..##", '.');
        patterns.put("..#.#", '#');
        patterns.put("####.", '.');
        patterns.put("##.##", '.');
        patterns.put("#....", '.');
        patterns.put("###..", '#');
        patterns.put("#####", '#');
        patterns.put("##..#", '#');
        patterns.put("#.###", '#');
        patterns.put("#..#.", '#');
        patterns.put(".####", '#');
        patterns.put("#.#..", '#');
        patterns.put(".###.", '#');
        patterns.put(".##..", '#');
        patterns.put(".#...", '#');
        patterns.put(".#.##", '#');
        patterns.put("##...", '#');
        patterns.put("..###", '.');
        patterns.put("##.#.", '.');
        patterns.put("...##", '.');
        patterns.put("....#", '.');
        patterns.put("###.#", '.');
        patterns.put("#.##.", '#');
        patterns.put(".##.#", '.');
        patterns.put(".#..#", '#');
        patterns.put("#.#.#", '#');
        patterns.put(".#.#.", '#');
        patterns.put("...#.", '#');
        patterns.put("#...#", '#');

        return patterns;
    }
}
