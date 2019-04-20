import Utils.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {

    private static int total = 0;
    private static Set<Integer> frequency = new HashSet<>();

    public static void partTwo() {
        System.out.println("Day One, Part Two:");
        final List<String> input = new FileReader("src/main/resources/Day1Input.txt").readFile();
        boolean duplicateTotalFound = processNumbers(input);
        while (!duplicateTotalFound) {
            duplicateTotalFound = processNumbers(input);
        }
        System.out.println(total);
    }

    private static boolean processNumbers(List<String> input) {
        for (String numStr : input) {
            boolean frequencyUpdated = processNumber(Integer.parseInt(numStr));
            if (!frequencyUpdated) {
                return true;
            }
        }
        return false;
    }

    private static boolean processNumber(final int number) {
        updateTotal(number);
        return updateFrequency();
    }

    private static void updateTotal(final int number) {
        total += number;
    }

    private static boolean updateFrequency() {
        if (!frequency.contains(total)) {
            frequency.add(total);
            return true;
        }
        return false;
    }
}
