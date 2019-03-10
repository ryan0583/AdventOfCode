import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Day6 {

//    private static int maxDist = 32;
//
//    private static List<String> input = Arrays.asList("1;1, 1",
//            "2;1, 6",
//            "3;8, 3",
//            "4;3, 4",
//            "5;5, 5",
//            "6;8, 9");

    private static int maxDist = 10000;

    private static List<String> input = Arrays.asList("1;152, 292",
            "2;163, 90",
            "3;258, 65",
            "4;123, 147",
            "5;342, 42",
            "6;325, 185",
            "7;69, 45",
            "8;249, 336",
            "9;92, 134",
            "10;230, 241",
            "11;74, 262",
            "12;241, 78",
            "13;299, 58",
            "14;231, 146",
            "15;239, 87",
            "16;44, 157",
            "17;156, 340",
            "18;227, 226",
            "19;212, 318",
            "20;194, 135",
            "21;235, 146",
            "22;171, 197",
            "23;160, 59",
            "24;218, 205",
            "25;323, 102",
            "26;290, 356",
            "27;244, 214",
            "28;174, 250",
            "29;70, 331",
            "30;288, 80",
            "31;268, 128",
            "32;359, 98",
            "33;78, 249",
            "34;221, 48",
            "35;321, 228",
            "36;52, 225",
            "37;151, 302",
            "38;183, 150",
            "39;142, 327",
            "40;172, 56",
            "41;72, 321",
            "42;225, 298",
            "43;265, 300",
            "44;86, 288",
            "45;78, 120",
            "46;146, 345",
            "47;268, 181",
            "48;243, 235",
            "49;262, 268",
            "50;40, 60");

    public static void partOne() {
        System.out.println("Day Six, Part One:");

        Integer[][] arr = generateArray();

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                arr[y][x] = findMinCoordId(x, y);
            }
        }

        //System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
        HashSet<Integer> edgeCoordIds = findEdgeCoordIds(arr);

        HashMap<Integer, Integer> coordIdToAreaSize = new HashMap<>();

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                int coordId = arr[y][x];
                if (coordId > 0 && !edgeCoordIds.contains(coordId)) {
                    int existingCount = 0;
                    if (coordIdToAreaSize.containsKey(coordId))
                    {
                        existingCount = coordIdToAreaSize.get(coordId);
                    }
                    existingCount++;
                    coordIdToAreaSize.put(coordId, existingCount);
                }
            }
        }

        //System.out.println(coordIdToAreaSize);

        int maxArea = 0;

        for (int area : coordIdToAreaSize.values()) {
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }

    public static void partTwo() {
        System.out.println("Day Six, Part Two:");

        Integer[][] arr = generateArray();
        int totalArea = 0;

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                if (findTotalCoordDist(x, y) < maxDist) {
                    totalArea++;
                }
            }
        }

        System.out.println(totalArea);
    }

    private static int findTotalCoordDist(int x, int y) {
        int totalCoordDist = 0;

        for (String str : input) {
            String coords = parseCoords(str);
            totalCoordDist += (Math.abs(x - parseX(coords)) + Math.abs(y - parseY(coords)));
        }

        //System.out.println(totalCoordDist);

        return totalCoordDist;
    }

    private static int findMinCoordId(int x, int y) {
        int minDist = Integer.MAX_VALUE;
        int minCoordId = 0;

        for (String str : input) {
            String coords = parseCoords(str);
            int dist = Math.abs(x - parseX(coords)) + Math.abs(y - parseY(coords));

            if (dist < minDist) {
                minDist = dist;
                minCoordId = parseCoordId(str);
            } else if (dist == minDist) {
                minCoordId = 0;
            }
        }

        return minCoordId;
    }

    private static HashSet<Integer> findEdgeCoordIds(Integer[][] arr) {
        HashSet<Integer> edgeCoords = new HashSet<>();

        int xLength = arr[0].length;

        for (int y = 0; y < arr.length; y++) {
            if (y == 0 || y == arr.length - 1) {
                for (int x = 0; x < xLength; x++) {
                    edgeCoords.add(arr[y][x]);
                }
            }
            edgeCoords.add(arr[y][0]);
            edgeCoords.add(arr[y][xLength - 1]);
        }

        return edgeCoords;
    }

    private static Integer[][] generateArray() {
        int xMax = 0;
        int yMax = 0;

        for (String str : input) {
            String coords = parseCoords(str);
            int x = parseX(coords);
            int y = parseY(coords);

            if (x > xMax) {
                xMax = x;
            }

            if (y > yMax) {
                yMax = y;
            }
        }

        Integer[][] arr = new Integer[xMax][yMax];

        for (Integer[] row : arr) {
            Arrays.fill(row, 0);
        }

        //System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
        //System.out.println(xMax + ", " + yMax);

        return arr;
    }

    private static String parseCoords(String input) {
        return input.substring(input.indexOf(';') + 1);
    }

    private static int parseX(String startCoords) {
        return Integer.parseInt(startCoords.substring(0, startCoords.indexOf(',')));
    }

    private static int parseY(String startCoords) {
        return Integer.parseInt(startCoords.substring(startCoords.indexOf(',') + 2));
    }

    private static int parseCoordId(String claim) {
        return Integer.parseInt(claim.substring(0, claim.indexOf(';')));
    }
}
