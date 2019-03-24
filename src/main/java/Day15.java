import Objects.Day15.Combatant;
import Objects.Day15.GameBoard;
import Objects.Day15.Space;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day15 {

    public static void partOne() {
        GameBoard gameBoard = generateGameBoard();
        List<Combatant> combatants = findCombatants(gameBoard);

        printGameBoard(gameBoard, combatants);

        int completedTurns = 0;

//        while (mixedCombatants(combantants)) {
        while (completedTurns < 7) {
            System.out.println("----------------------------------");
            Collections.sort(combatants);
            for (Combatant combatant : combatants) {
                Set<Space> occupiedSpaces = combatants.stream()
                        .filter(otherCombatant -> !otherCombatant.equals(combatant))
                        .map(Combatant::getCurrentPosition)
                        .collect(Collectors.toSet());

                List<Space> targetSpaces = findTargetSpaces(combatant, combatants, gameBoard, occupiedSpaces);
                if (shouldMove(combatant, targetSpaces)) {
                    Space space = findNearestReachableSpace(combatant, targetSpaces, gameBoard, occupiedSpaces);
                    if (space != null) {
                        List<Space> route = space.getRoute(new ArrayList<>());
                        Space nextStep = route.get(1);
                        combatant.setCurrentPosition(new Space(nextStep.getxCoord(), nextStep.getyCoord()));
                    }
                }
            }

            printGameBoard(gameBoard, combatants);

            completedTurns++;
            System.out.println(completedTurns);
        }
    }

    private static boolean mixedCombatants(List<Combatant> combatants) {
        boolean mixedCombatants = false;
        Character foundType = null;

        for (Combatant combatant : combatants) {
            if (foundType == null) {
                foundType = combatant.getType();
            } else if (!combatant.getType().equals(foundType)) {
                mixedCombatants = true;
                break;
            }
        }

        return mixedCombatants;
    }

    private static List<Space> findTargetSpaces(Combatant combatant,
                                                List<Combatant> combatants,
                                                GameBoard gameBoard,
                                                Set<Space> occupiedSpaces) {
        List<Space> targetSpaces = new ArrayList<>();

        for (Combatant targetCombatant : combatants) {
            if (!combatant.getType().equals(targetCombatant.getType())) {
                Space targetSpace = targetCombatant.getCurrentPosition();
                targetSpaces.addAll(findUnoccupiedAdjacentSpaces(targetSpace, gameBoard, occupiedSpaces));
            }
        }

        return targetSpaces;
    }

    private static List<Space> findUnoccupiedAdjacentSpaces(Space space,
                                                            GameBoard gameBoard,
                                                            Set<Space> occupiedSpaces) {
        List<Space> potentialAdjacentSpaces = new ArrayList<>();
        potentialAdjacentSpaces.add(new Space(space.getxCoord() - 1, space.getyCoord()));
        potentialAdjacentSpaces.add(new Space(space.getxCoord() + 1, space.getyCoord()));
        potentialAdjacentSpaces.add(new Space(space.getxCoord(), space.getyCoord() - 1));
        potentialAdjacentSpaces.add(new Space(space.getxCoord(), space.getyCoord() + 1));
        List<Space> adjacentSpaces = new ArrayList<>();
        for (Space potentialTargetSpace : potentialAdjacentSpaces) {
            if (!occupiedSpaces.contains(potentialTargetSpace)
                    && gameBoard.getGameBoard()[potentialTargetSpace.getyCoord()][potentialTargetSpace.getxCoord()] == '.') {
                adjacentSpaces.add(potentialTargetSpace);
            }
        }
        return adjacentSpaces;
    }

    private static Space findNearestReachableSpace(Combatant combatant,
                                                   List<Space> targetSpaces,
                                                   GameBoard gameBoard,
                                                   Set<Space> occupiedSpaces) {
        //System.out.println("Finding reachable space for " + combatant.getCurrentPosition());
        List<Space> nearestReachableSpaces = new ArrayList<>();
        int fewestSteps = Integer.MAX_VALUE;
        Space currentSpace = combatant.getCurrentPosition();
        for (Space targetSpace : targetSpaces) {
            //System.out.println("Target space: " + targetSpace);
            if (Math.abs(currentSpace.getxCoord() - targetSpace.getxCoord()) + Math.abs(currentSpace.getyCoord() - targetSpace.getyCoord()) <= fewestSteps) {
                Space shortestRoute = createRoute(currentSpace, targetSpace, gameBoard, occupiedSpaces, new HashSet<>(), null);
                if (shortestRoute != null) {
                    if (currentSpace.isRoutable()) {
                        int routeSteps = shortestRoute.getRouteSteps();
                        if (routeSteps < fewestSteps) {
                            fewestSteps = routeSteps;
                            nearestReachableSpaces.clear();
                            nearestReachableSpaces.add(shortestRoute);
                        } else if (routeSteps == fewestSteps) {
                            nearestReachableSpaces.add(shortestRoute);
                        }
                    }
                }
            }
        }

        Collections.sort(nearestReachableSpaces);
        if (!nearestReachableSpaces.isEmpty()) {
            return nearestReachableSpaces.get(0);
        }
        return null;
    }

    private static Space createRoute(Space space,
                                     Space targetSpace,
                                     GameBoard gameBoard,
                                     Set<Space> occupiedSpaces,
                                     Set<Space> previousSpaces,
                                     Space shortestRoute) {
//        if (targetSpace.equals(new Space(5, 4))
//                && space.equals(new Space(5, 3))) {
//            System.out.println(space);
//        }

        if (shortestRoute != null
                && space.getRouteSteps() > shortestRoute.getRouteSteps()) {
            return shortestRoute;
        }

        if (space.equals(targetSpace)) {
            space.setRoutable(true);
            if (shortestRoute == null
                    || space.getRouteSteps() < shortestRoute.getRouteSteps()) {
                shortestRoute = space;
            }
            return shortestRoute;
        }

        previousSpaces.add(space);
        space.setAdjacentSpaces(findUnoccupiedAdjacentSpaces(space, gameBoard, occupiedSpaces).stream()
                .filter(spaces -> !previousSpaces.contains(spaces))
                .collect(Collectors.toList()));

        List<Space> adjacentSpaces = space.getAdjacentSpaces();
//        if (targetSpace.equals(new Space(5, 4))
//                && adjacentSpaces.isEmpty()) {
//            System.out.println("No Move Available!");
//        }

        Collections.sort(adjacentSpaces);
        for (Space nextSpace : adjacentSpaces) {
            nextSpace.setPreviousSpace(space);
            shortestRoute = createRoute(nextSpace, targetSpace, gameBoard, occupiedSpaces, previousSpaces, shortestRoute);
        }
        previousSpaces.remove(space);

        space.setRoutable(!space.getAdjacentSpaces()
                .stream()
                .filter(Space::isRoutable)
                .collect(Collectors.toList())
                .isEmpty());

        return shortestRoute;
    }

    private static Collection<Space> sortSpacesByDistance(List<Space> spaces, Space targetSpace) {
        SortedMap<Integer, Space> distanceToSpace = new TreeMap<>();
        for (Space space : spaces) {
            int distance = Math.abs(space.getxCoord() - targetSpace.getxCoord()) + Math.abs(space.getyCoord() - targetSpace.getyCoord());
            distanceToSpace.put(distance, space);
        }

        return distanceToSpace.values();
    }

    private static boolean shouldMove(Combatant combatant, List<Space> targetSpaces) {
        boolean shouldMove = true;
        for (Space targetSpace : targetSpaces) {
            if (targetSpace.equals(combatant.getCurrentPosition())) {
                shouldMove = false;
                break;
            }
        }
        return shouldMove;
    }

    private static GameBoard generateGameBoard() {
        List<String> fileLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Day15Input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }

            br.close();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

        int xDim = 0;
        for (String line : fileLines) {
            if (line.length() > xDim) {
                xDim = line.length();
            }
        }

        char[][] gameBoard = new char[fileLines.size()][xDim];

        for (char[] row : gameBoard) {
            Arrays.fill(row, ' ');
        }

        for (int y = 0; y < fileLines.size(); y++) {
            char[] row = fileLines.get(y).toCharArray();
            for (int x = 0; x < row.length; x++) {
                gameBoard[y][x] = row[x];
            }
        }

        return new GameBoard(gameBoard);
    }

    private static List<Combatant> findCombatants(GameBoard gameBoard) {
        List<Combatant> combatants = new ArrayList<>();
        Set<Character> combantantChars = Set.of('E', 'G');

        for (int y = 0; y < gameBoard.getGameBoard().length; y++) {
            for (int x = 0; x < gameBoard.getGameBoard()[0].length; x++) {
                char c = gameBoard.getGameBoard()[y][x];
                if (combantantChars.contains(c)) {
                    combatants.add(new Combatant(c, new Integer[]{x, y}));
                    gameBoard.getGameBoard()[y][x] = '.';
                }
            }
        }

        return combatants;
    }

    private static void printGameBoard(GameBoard gameBoard, List<Combatant> combatants) {
        char[][] trackToPrint = new char[gameBoard.getGameBoard().length][gameBoard.getGameBoard()[0].length];

        for (int y = 0; y < gameBoard.getGameBoard().length; y++) {
            trackToPrint[y] = Arrays.copyOf(gameBoard.getGameBoard()[y], gameBoard.getGameBoard()[y].length);
        }

        for (Combatant combatant : combatants) {
            Space position = combatant.getCurrentPosition();
            trackToPrint[position.getyCoord()][position.getxCoord()] = combatant.getType();
        }

        System.out.println(Arrays.deepToString(trackToPrint).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
    }
}
