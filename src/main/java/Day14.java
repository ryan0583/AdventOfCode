import Objects.Day14.Elf;

import java.util.ArrayList;
import java.util.List;

public class Day14 {

    public static void partOne() {
        List<Integer> recipeScores = new ArrayList<>();
        recipeScores.add(3);
        recipeScores.add(7);
        Elf elf1 = new Elf(recipeScores.get(0), 0);
        Elf elf2 = new Elf(recipeScores.get(1), 1);

        int numRecipes = 793031;

        while (recipeScores.size() <= numRecipes + 9) {
            addNewRecipes(recipeScores, elf1, elf2);
            moveRecipes(recipeScores, elf1);
            moveRecipes(recipeScores, elf2);
        }

        System.out.println(recipeScores.subList(numRecipes, recipeScores.size()));
    }

    public static void partTwo() {

        List<Integer> recipeScores = new ArrayList<>();
        recipeScores.add(3);
        recipeScores.add(7);
        Elf elf1 = new Elf(recipeScores.get(0), 0);
        Elf elf2 = new Elf(recipeScores.get(1), 1);

        String expectedPattern = "793031";
        int numPreviousRecipes = -1;

        while (numPreviousRecipes == -1) {
            addNewRecipes(recipeScores, elf1, elf2);
            moveRecipes(recipeScores, elf1);
            moveRecipes(recipeScores, elf2);

            if (recipeScores.size() > expectedPattern.length() + 1) {
                List<Integer> lastCharacters = recipeScores.subList(recipeScores.size() - expectedPattern.length() - 1, recipeScores.size());

                String lastCharactersStr = lastCharacters.toString()
                        .replace("[", "")
                        .replace(", ", "")
                        .replace("]", "");

                if (lastCharactersStr.contains(expectedPattern)) {
                    System.out.println("found!");
                    System.out.println(lastCharactersStr);
                    numPreviousRecipes = recipeScores.size() - expectedPattern.length();
                    if (lastCharactersStr.indexOf(expectedPattern) == 0) {
                        numPreviousRecipes--;
                    }
                }
            }
        }

        System.out.println(numPreviousRecipes);
    }

    private static void addNewRecipes(List<Integer> recipeScores, Elf elf1, Elf elf2) {
        int sum = elf1.getCurrentScore() + elf2.getCurrentScore();
        if (sum < 10) {
            recipeScores.add(sum);
        } else {
            recipeScores.add((sum % 100 - sum % 10) / 10);
            recipeScores.add(sum % 10);
        }
    }

    private static void moveRecipes(List<Integer> recipeScores, Elf elf) {
        int currentPosition = elf.getCurrentPosition();
        int numberToMove = elf.getCurrentScore() + 1;
        int newPosition = (currentPosition + numberToMove) % recipeScores.size();
        elf.setCurrentScore(recipeScores.get(newPosition));
        elf.setCurrentPosition(newPosition);
    }
}
