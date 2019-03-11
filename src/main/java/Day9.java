import Objects.Marble;

import java.util.HashMap;

public class Day9 {

    public static void partOne() {
        System.out.println("Day Nine, Part One:");
        getMaxScore(71511);
    }

    public static void partTwo() {
        System.out.println("Day Nine, Part Two:");
        getMaxScore(7151001);
    }

    private static void getMaxScore(int numberOfMarbles) {
        int numPlayers = 447;

        Marble firstMarble = new Marble(0);
        Marble currentMarble = firstMarble;
        currentMarble.setNextMarble(currentMarble);
        currentMarble.setPreviousMarble(currentMarble);
        int nextMarbleValue = 1;
        int currentPlayer = 1;
        HashMap<Integer, Long> playerScores = new HashMap<>();

        while (nextMarbleValue < numberOfMarbles) {
            if (!playerScores.containsKey(currentPlayer)) {
                playerScores.put(currentPlayer, (long)0);
            }

            if (nextMarbleValue % 23 == 0) {
                Marble marbleToRemove = currentMarble;
                for (int i = 0; i < 7; i++) {
                    marbleToRemove = marbleToRemove.getPreviousMarble();
                }

                //add to score
                playerScores.put(currentPlayer, playerScores.get(currentPlayer) + marbleToRemove.getValue() + nextMarbleValue);
                currentMarble = marbleToRemove.getNextMarble();
                //remove marble
                marbleToRemove.getPreviousMarble().setNextMarble(marbleToRemove.getNextMarble());
            } else {
                Marble marbleToPlace = new Marble(nextMarbleValue);
                placeNextMarble(currentMarble, marbleToPlace);
                currentMarble = marbleToPlace;
            }
            nextMarbleValue++;
            currentPlayer++;
            if (currentPlayer > numPlayers) {
                currentPlayer = 1;
            }

//            printMarbles(firstMarble);
        }

        long maxScore = 0;
        for (long score : playerScores.values()) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        System.out.println(maxScore);
    }

    private static void placeNextMarble(Marble currentMarble, Marble marbleToPlace) {
        Marble currentMarblePlusOne = currentMarble.getNextMarble();
        Marble currentMarblePlusTwo = currentMarblePlusOne.getNextMarble();

        currentMarblePlusOne.setNextMarble(marbleToPlace);
        currentMarblePlusTwo.setPreviousMarble(marbleToPlace);
        marbleToPlace.setPreviousMarble(currentMarblePlusOne);
        marbleToPlace.setNextMarble(currentMarblePlusTwo);
    }

    private static void printMarbles(Marble firstMarble) {
        StringBuilder output = new StringBuilder();
        output.append(firstMarble.getValue() + ", ");
        Marble nextMarble = firstMarble.getNextMarble();
        while (nextMarble.getValue() != firstMarble.getValue()) {
            output.append(nextMarble.getValue() + ", ");
            nextMarble = nextMarble.getNextMarble();
        }

        System.out.println(output);
    }
}
