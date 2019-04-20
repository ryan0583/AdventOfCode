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
        boolean done = false;

        while (!done) {
            System.out.println("-------------------------------------------");

            Collections.sort(combatants);

            for (Combatant combatant : combatants) {
                if (combatant.isDead()) {
                    continue;
                }

                List<Combatant> aliveCombatants = combatants
                        .stream()
                        .filter(Combatant::isAlive)
                        .collect(Collectors.toList());

                if (!mixedCombatants(aliveCombatants)) {
                    done = true;
                    break;
                }

                Set<Space> occupiedSpaces = aliveCombatants.stream()
                        .filter(otherCombatant -> !otherCombatant.equals(combatant))
                        .map(Combatant::getCurrentPosition)
                        .collect(Collectors.toSet());

                Set<Space> targetSpaces = findTargetSpaces(combatant, aliveCombatants, gameBoard, occupiedSpaces);

                move(gameBoard, combatant, occupiedSpaces, targetSpaces);

                attack(gameBoard, combatant, aliveCombatants);
            }

            if (!done) {
                completedTurns++;
            }
            System.out.println(completedTurns);
            printGameBoard(gameBoard, combatants.stream().filter(Combatant::isAlive).collect(Collectors.toList()));
        }

        Integer totalRemainingHitPoints = combatants
                .stream()
                .filter(Combatant::isAlive)
                .map(Combatant::getHp)
                .reduce((a, b) -> a + b)
                .orElse(0);

        System.out.println(completedTurns);
        System.out.println(totalRemainingHitPoints);
        System.out.println(completedTurns * totalRemainingHitPoints);
    }

    public static void partTwo() {
        int elfAttackPoints = 4;

        while (true) {
            GameBoard gameBoard = generateGameBoard();
            List<Combatant> combatants = findCombatants(gameBoard);

            final int currentElfAttackPoints = elfAttackPoints;
            combatants
                    .stream()
                    .filter(combatant -> combatant.getType().equals('E'))
                    .forEach(combatant -> combatant.setAttackPoints(currentElfAttackPoints));

            printGameBoard(gameBoard, combatants);

            int completedTurns = 0;
            boolean done = false;
            while (!done) {
                System.out.println("-------------------------------------------");

                Collections.sort(combatants);

                for (Combatant combatant : combatants) {
                    if (combatant.isDead()) {
                        if (combatant.getType().equals('E')) {
                            done = true;
                            break;
                        }
                        continue;
                    }

                    List<Combatant> aliveCombatants = combatants
                            .stream()
                            .filter(Combatant::isAlive)
                            .collect(Collectors.toList());

                    if (!mixedCombatants(aliveCombatants)) {
                        done = true;
                        break;
                    }

                    Set<Space> occupiedSpaces = aliveCombatants.stream()
                            .filter(otherCombatant -> !otherCombatant.equals(combatant))
                            .map(Combatant::getCurrentPosition)
                            .collect(Collectors.toSet());

                    Set<Space> targetSpaces = findTargetSpaces(combatant, aliveCombatants, gameBoard, occupiedSpaces);

                    move(gameBoard, combatant, occupiedSpaces, targetSpaces);

                    attack(gameBoard, combatant, aliveCombatants);
                }

                if (!done) {
                    completedTurns++;
                }
                System.out.println(completedTurns);
                printGameBoard(gameBoard, combatants.stream().filter(Combatant::isAlive).collect(Collectors.toList()));
            }

            if (!mixedCombatants(combatants)) {
                Integer totalRemainingHitPoints = combatants
                        .stream()
                        .filter(Combatant::isAlive)
                        .map(Combatant::getHp)
                        .reduce((a, b) -> a + b)
                        .orElse(0);

                System.out.println(completedTurns);
                System.out.println(totalRemainingHitPoints);
                System.out.println(completedTurns * totalRemainingHitPoints);
                break;
            } else {
                System.out.println("ELF DIED, TRYING AGAIN!");
                elfAttackPoints++;
            }
        }
    }

    private static void move(GameBoard gameBoard, Combatant combatant, Set<Space> occupiedSpaces, Set<Space> targetSpaces) {
        if (!targetSpaces.isEmpty()
                && shouldMove(combatant, targetSpaces)) {
            Set<Space> visitedSpaces = new HashSet<>();
            visitedSpaces.add(combatant.getCurrentPosition());
            Space space = findNearestReachableSpace(Collections.singletonList(combatant.getCurrentPosition()),
                    visitedSpaces,
                    targetSpaces,
                    gameBoard,
                    occupiedSpaces);

            if (space != null) {
                List<Space> route = space.getRoute(new ArrayList<>());
                Space nextStep = route.get(1);
                combatant.setCurrentPosition(new Space(null, nextStep.getxCoord(), nextStep.getyCoord()));
            }
        }
    }

    private static void attack(GameBoard gameBoard, Combatant combatant, List<Combatant> aliveCombatants) {
        Combatant combatantToAttack = findTargetCombatant(combatant,
                gameBoard,
                aliveCombatants
                        .stream()
                        .filter(otherCombantant -> !otherCombantant.getType().equals(combatant.getType()))
                        .collect(Collectors.toList()));
        if (combatantToAttack != null) {
            combatantToAttack.sufferAttack(combatant.getAttackPoints());
        }
    }

    private static Combatant findTargetCombatant(Combatant currentCombatant,
                                                 GameBoard gameBoard,
                                                 List<Combatant> combatants) {
        List<Combatant> targetCombatants = new ArrayList<>();
        int lowHp = Integer.MAX_VALUE;

        Set adjSpaces = findUnoccupiedAdjacentSpaces(currentCombatant.getCurrentPosition(),
                gameBoard,
                Collections.EMPTY_SET);

        for (Combatant combatant : combatants) {
            if (adjSpaces.contains(combatant.getCurrentPosition())) {
                int hp = combatant.getHp();
                if (hp <= lowHp) {
                    if (hp < lowHp) {
                        targetCombatants.clear();
                    }
                    targetCombatants.add(combatant);
                    lowHp = hp;
                }
            }
        }

        if (targetCombatants.isEmpty()) {
            return null;
        }
        Collections.sort(targetCombatants);
        return targetCombatants.get(0);
    }

    private static boolean mixedCombatants(List<Combatant> combatants) {
        List<Combatant> aliveCombatants = combatants
                .stream()
                .filter(Combatant::isAlive)
                .collect(Collectors.toList());

        boolean mixedCombatants = false;
        Character foundType = null;

        for (Combatant combatant : aliveCombatants) {
            if (foundType == null) {
                foundType = combatant.getType();
            } else if (!combatant.getType().equals(foundType)) {
                mixedCombatants = true;
                break;
            }
        }

        return mixedCombatants;
    }

    private static Set<Space> findTargetSpaces(Combatant combatant,
                                               List<Combatant> combatants,
                                               GameBoard gameBoard,
                                               Set<Space> occupiedSpaces) {
        Set<Space> targetSpaces = new HashSet<>();

        for (Combatant targetCombatant : combatants) {
            if (!combatant.getType().equals(targetCombatant.getType())) {
                Space targetSpace = targetCombatant.getCurrentPosition();
                targetSpaces.addAll(findUnoccupiedAdjacentSpaces(targetSpace, gameBoard, occupiedSpaces));
            }
        }

        return targetSpaces;
    }

    private static Set<Space> findUnoccupiedAdjacentSpaces(Space space,
                                                           GameBoard gameBoard,
                                                           Set<Space> occupiedSpaces) {
        Set<Space> potentialAdjacentSpaces = new HashSet<>();
        potentialAdjacentSpaces.add(new Space(space, space.getxCoord() - 1, space.getyCoord()));
        potentialAdjacentSpaces.add(new Space(space, space.getxCoord() + 1, space.getyCoord()));
        potentialAdjacentSpaces.add(new Space(space, space.getxCoord(), space.getyCoord() - 1));
        potentialAdjacentSpaces.add(new Space(space, space.getxCoord(), space.getyCoord() + 1));
        Set<Space> adjacentSpaces = new HashSet<>();
        for (Space potentialTargetSpace : potentialAdjacentSpaces) {
            if (!occupiedSpaces.contains(potentialTargetSpace)
                    && gameBoard.getGameBoard()[potentialTargetSpace.getyCoord()][potentialTargetSpace.getxCoord()] == '.') {
                adjacentSpaces.add(potentialTargetSpace);
            }
        }
        return adjacentSpaces;
    }

    private static Space findNearestReachableSpace(List<Space> prevDepthSpaces,
                                                   Set<Space> visitedSpaces,
                                                   Set<Space> targetSpaces,
                                                   GameBoard gameBoard,
                                                   Set<Space> occupiedSpaces) {
        List<Space> thisDepthSpaces = new ArrayList<>();

        for (Space space : prevDepthSpaces) {
            thisDepthSpaces.addAll(findUnoccupiedAdjacentSpaces(space, gameBoard, occupiedSpaces)
                    .stream()
                    .filter(adjSpace -> !visitedSpaces.contains(adjSpace))
                    .collect(Collectors.toList()));
        }

        if (thisDepthSpaces.isEmpty()) {
            return null;
        } else {
            List<Space> reachableTargets = thisDepthSpaces
                    .stream()
                    .filter(targetSpaces::contains)
                    .collect(Collectors.toList());

            if (reachableTargets.isEmpty()) {
                visitedSpaces.addAll(thisDepthSpaces);
                return findNearestReachableSpace(thisDepthSpaces,
                        visitedSpaces,
                        targetSpaces,
                        gameBoard,
                        occupiedSpaces);
            } else {
                Collections.sort(reachableTargets);
                return reachableTargets.get(0);
            }
        }
    }

    private static boolean shouldMove(Combatant combatant, Set<Space> targetSpaces) {
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
        combatants.forEach(combantant -> System.out.println(combantant.getType() + " - " + combantant.getHp()));
    }
}
