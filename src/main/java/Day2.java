import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day2 {

    private static List<String> input = Arrays.asList("wlpiogsvdfecjdqmnxakudrhbz",
            "wbpioesvyfecjuqmlxaktdrhbz",
            "blviogavyfecjuqmnxaktdrhbz",
            "wlpiogsvydecjuqmnipktdrhbz",
            "wlwiogsvyfmcjuqmoxaktdrhbz",
            "wlpiogsvphecjuqmnxaktdrzbz",
            "wlpiogsvyfecjuqmnkakhdrkbz",
            "wlpiogsvyfhcjuqmnxxktddhbz",
            "wlpiogsvyfccfuqmnxgktdrhbz",
            "wlpiogsvhmecjvqmnxaktdrhbz",
            "wlpiogsvyfecjdqqnxaktdrhyz",
            "wlpiogyvycecjaqmnxaktdrhbz",
            "wlpiogsvyfecjfqmnxaktybhbz",
            "wkpiogsvyfmcauqmnxaktdrhbz",
            "wlmiolsvyfecjuqmnxaktdrhbn",
            "wlpioksvyfecjuqmnxaktdrhgs",
            "wlpiogsvyflcjuvmnxsktdrhbz",
            "wgziogsvyfecjuqmnxaktdrhoz",
            "whpingsvyeecjuqmnxaktdrhbz",
            "wlpiogsvyfecjuqgnxaktdvhlz",
            "wlpioasvtfecjuqmnxaktdahbz",
            "wlpihgsvefeceuqmnxaktdrhbz",
            "wlpiogsvyfecyuqwnxaktdghbz",
            "wlpfsgsvyfhcjuqmnxaktdrhbz",
            "wlpiogyvyfecjuqmnxalpdrhbz",
            "wlpiogsvyfescsqmnxaktdrhbz",
            "wluiogsvyfecytqmnxaktdrhbz",
            "wltiorsvyfecjuqmoxaktdrhbz",
            "wlmiogwvyfejjuqmnxaktdrhbz",
            "wlpiogsvyfycjuumnxvktdrhbz",
            "wlkiogsqyfecjqqmnxaktdrhbz",
            "wlpiogsvyfecouqmnxaktfrubz",
            "hupiogsvlfecjuqmnxaktdrhbz",
            "wlpiogsvpxecjuqmnxaksdrhbz",
            "wlpiogsvyfkcjfqmnxxktdrhbz",
            "wlpiogsjyfecjuqnnxakthrhbz",
            "wlpiogsvyfecjuqmnxaktddhdk",
            "wlpipgsvyfecjuqmnhaktdrubz",
            "wlpiogsoyfenjpqmnxaktdrhbz",
            "wlpiogsvyfecnuqmnxaxtdrmbz",
            "wlpiggsvyfjcjuumnxaktdrhbz",
            "wlppogsvyfecjuqmnxautdhhbz",
            "wlpiovbvyfecjuqmnxaktcrhbz",
            "wlpiogsvyfecjoqmnxaktdrobu",
            "wlpiohsvyfecjugmnxakthrhbz",
            "wvpiogovyfecjuqmnxakwdrhbz",
            "wlpiogsbyfecjuqmnxdktdrtbz",
            "wlpnogsvyfecjuqmnxakykrhbz",
            "wlpiogpvyfecjuqmnxvktdrhbs",
            "wlpiogsvkvecjuqmnxadtdrhbz",
            "wlkihgsvyfecjuqmnxlktdrhbz",
            "wlpilgsvyfhcjuqmnxakudrhbz",
            "wlpioksvysgcjuqmnxaktdrhbz",
            "wlpiogsvyfecorqmoxaktdrhbz",
            "wlpiogsvyfectzlmnxaktdrhbz",
            "wlpiogsvywecjuqwnqaktdrhbz",
            "wlpiowsvyfecjuqrnxaftdrhbz",
            "wlpiogsuyfecjutmnxaktnrhbz",
            "wepiowsvyfqcjuqmnxaktdrhbz",
            "wlpirgssyfecjuqmvxaktdrhbz",
            "wlyiogstyfecjuqmnxaktdrhbw",
            "wlpiogseyfecauqmnxaktdjhbz",
            "wlpioisvyfenjuqmnxakrdrhbz",
            "wlpiogsvyfrgjfqmnxaktdrhbz",
            "wlpionsvyfecjmqmjxaktdrhbz",
            "alpiggsvyfecjuqmnxaktdrhkz",
            "wlphngsvyfecjuqmnxfktdrhbz",
            "wlpiogsvyferjuqmlxakttrhbz",
            "wlniogsvefecjuqsnxaktdrhbz",
            "wlpiogsvyfncjurmnxakudrhbz",
            "wlpiogsvyfecjuqmnxaktprlaz",
            "wlpiocsvyfecjupmkxaktdrhbz",
            "wlpihgsvyfecjeqfnxaktdrhbz",
            "wlwioasvyfjcjuqmnxaktdrhbz",
            "wlpifgsvyfecjuqsnxaktdshbz",
            "wlxiogsvyrechuqmnxaktdrhbz",
            "wlpiogovyfxcjuqmnxakkdrhbz",
            "wlpiogsvyfecjkqmdxaktmrhbz",
            "wlpiogsvyfecjwqmntaktdhhbz",
            "wlpiogsvdfecjuqmmxaktbrhbz",
            "wlpiogsvyfecauqmnxaksdrhwz",
            "wlpiogsvwfecjuqznxaktorhbz",
            "wlpiogtvyfecjuqhnxakidrhbz",
            "wlpiogsvyyecjuqmnxaktdrhwt",
            "wljiogsvyfecfuqbnxaktdrhbz",
            "wlpiogsvybecjuqmnxagtdrjbz",
            "wrpiogsvyfecjuqmnuaktdrhbd",
            "wlpiogsvyfecjurmnxnltdrhbz",
            "blpvogsvyaecjuqmnxaktdrhbz",
            "bfpiogyvyfecjuqmnxaktdrhbz",
            "wlpiogsvyfecjuqinxaknddhbz",
            "wlpizgsvvfecjuqxnxaktdrhbz",
            "glpiogsvyrecjuqmnxaktdrhbr",
            "wlpiogskhfecjutmnxaktdrhbz",
            "wlpiogsvyfecmuqmnxaktdribc",
            "wlpioesvwfecjuqmnxakkdrhbz",
            "wlpionsrafecjuqmnxaktdrhbz",
            "wlsiogsvyfecjuqmnaaktdrhvz",
            "bloiogsvyfecjuqmnxakjdrhbz",
            "wlpiogsvyfecjuqenmastdrhbz",
            "wlpiogyvyfecjuqmuxakldrhbz",
            "plpiogovyfecjuvmnxaktdrhbz",
            "wlpiogsvyfebjuqmnkakvdrhbz",
            "wlziogsvyfhcjuqmngaktdrhbz",
            "wlsiogsvyfecjuqmnxaktdrzjz",
            "plbiogsvyfecfuqmnxaktdrhbz",
            "wfpiogsvyfecjuqknxaktdrhiz",
            "wlpiogjbyfecjuqmnxaktprhbz",
            "wmpiogsvyrecjcqmnxaktdrhbz",
            "wlpiogsyyfecjuqmqxaktdrbbz",
            "wlpiogsvyfecjuqknxaetdehbz",
            "wlpiogsvyfezjuqmnxakkdhhbz",
            "wlpiogsvyfecjjqvnxaktdrhiz",
            "wkpiogsvyfucjuqmnxaktdrhbd",
            "lliiogsvyfecjuqmnxaktdrhoz",
            "wlpiogsvyfecjuqmsxdktdshbz",
            "wlprogtvyfecjuqmnxaktvrhbz",
            "wlpizgssyffcjuqmnxaktdrhbz",
            "wlpioasvyfvcjuqmnxakldrhbz",
            "wlpoogsvyyecjuqmnxastdrhbz",
            "wlpiognvyfecjuqmnsaktdrhbr",
            "wlpiogsoyfecjuqmnxaktdrhho",
            "wfpiogsvydecjuqmnxaotdrhbz",
            "wlpiogsvqhecjuqmnxaktdrhhz",
            "wkpiogsvyfeojuqmnxaktdrqbz",
            "wlpiogsvyfeveuqmnxaktdshbz",
            "wlpiogbvyfecjuqmexaktdrcbz",
            "wlpxogsvyfehjsqmnxaktdrhbz",
            "wlpcogsvyfecjuqmnjakttrhbz",
            "wlpiogsvvkecjuqmnxaftdrhbz",
            "wlpiogsvffecnuqmnxaktdnhbz",
            "wlpiogsvyfecjupjnxaktdrhbr",
            "wlpqogsvyfecjuqmnxlktdphbz",
            "wlpxogsvyfecjvqmnxaktirhbz",
            "elpiogsvyfecjuqlnxaqtdrhbz",
            "wspiogsvrfecjuqmnxakadrhbz",
            "wlpiogsmyfecbuqmnxactdrhbz",
            "wlpiogsvyfecauqmnyakzdrhbz",
            "wlsiogsvyfecjuqmnxakvdrnbz",
            "wlpiogsxyfeijuqmnxakndrhbz",
            "wlpiogsvyfecjuumnxakbyrhbz",
            "wlpiogsvyfecjuqmnxhktdyhbo",
            "wlpiogsvyfecjuqqnxnjtdrhbz",
            "wapiogsvyfecjuqmnxoktdrmbz",
            "wlpiogsvyfeejvqmnxaktdrubz",
            "wlpitgsvyeectuqmnxaktdrhbz",
            "alpiogsvyfecjulmnxaktdchbz",
            "wlpiogsvyfecjuqmuxoktdrwbz",
            "wlpiogsvyfzgjuhmnxaktdrhbz",
            "wlpnogsvyfecjuqmdxaktyrhbz",
            "wlpiogsvyfecjuqmnxakthrhra",
            "wliiogsvyfecluqmnxaktdhhbz",
            "wlpiogsvyfecjuymnxaltdrhwz",
            "wlpiogsvyfeljuqmnxaktyrhbd",
            "wlpiygsvvfecjuqmfxaktdrhbz",
            "wlpiogihsfecjuqmnxaktdrhbz",
            "wlpiogjvyfecjuqmnhuktdrhbz",
            "wldiogsvyfecjiqmwxaktdrhbz",
            "wlpiogsvjfecjuqmnxaktdrgbr",
            "wlpioisvyfecjuqwnxabtdrhbz",
            "wlviogsvyfscjuqmnxqktdrhbz",
            "wlpiogsvyfecjuqmuxakbdrubz",
            "wlpiogsvyfecjuqmnxmatdrhqz",
            "wlpiogsvyfbcjuqwmxaktdrhbz",
            "wlpiogsvyfexjuqmnxuxtdrhbz",
            "wljiogsvbfecjuqmnxartdrhbz",
            "wlpvogsvyfeujuqmnxaktdmhbz",
            "wnpiogsvyfekjuqanxaktdrhbz",
            "wlprogsvyfecjuqmzxvktdrhbz",
            "wkpiogvvyfecjuqmnxaktdrabz",
            "wlpiogsvwfecjuqmnxaktkbhbz",
            "wlpiogsvyfecjlqmnxtttdrhbz",
            "wlpioqsvyfecjuqznxaktyrhbz",
            "wlpiogsvyfecjuqmnxnethrhbz",
            "wlpiogsyyfgcjuqmnxaktdrhbm",
            "wlpiopsvbfecjuqmnxaktdlhbz",
            "wloqogsvyfucjuqmnxaktdrhbz",
            "wlpiogsvmfecjuqmnxmktdrhtz",
            "wlhiogsvyfecjuhmnxaktsrhbz",
            "wlpioggvpfecjufmnxaktdrhbz",
            "wlpiogsvyfbcjuomnxaktdrhbh",
            "wlpmogsvyfecyuqmnxoktdrhbz",
            "wlpiogslyfecjuqmnxaptyrhbz",
            "tlpiogsnyfecguqmnxaktdrhbz",
            "wlpiogsvyfecjuqmnxwktwehbz",
            "wlpiogsvgfecjuqmnxaktdrabu",
            "wbpiogsvyfecjuqmnxagtdrhoz",
            "wlwipgsvyfecjuqmnxaktdrhbu",
            "wlpwogsvykeczuqmnxaktdrhbz",
            "wlpgogsvwfecjuqmnxcktdrhbz",
            "wlpiogsqyfecjuqmrxaktdrrbz",
            "wlpiogsvyfecjuqmnxakthrafz",
            "wypicgseyfecjuqmnxaktdrhbz",
            "wlpiogcvqfecjuqmnxaktdrhzz",
            "wlriogsvyfecouqmnkaktdrhbz",
            "wlpiogsvyfemjulmnxaktdrhdz",
            "flpiogadyfecjuqmnxaktdrhbz",
            "wupiogsvyfbvjuqmnxaktdrhbz",
            "wlpiogsvyfebjummnxaktdrrbz",
            "wjpiogsvyfecjuqmnxaktprybz",
            "wlpirgsvyfecjiqmnxaatdrhbz",
            "bvpiogsvyfecjuqmnxaktdrhez",
            "wlpiogsvyfxcjuqmnxykzdrhbz",
            "wlkiwgsqyfecjqqmnxaktdrhbz",
            "wepaogsvyfecjxqmnxaktdrhbz",
            "wlpiovsvyfecjjqmnxaktdmhbz",
            "wlpioysryfecjuqmnxaktdrhiz",
            "wlpizjsvyfecjuvmnxaktdrhbz",
            "dlpiogsvyfecjucmnxakbdrhbz",
            "wlpiogsccfecjrqmnxaktdrhbz",
            "wlpioggvyfecpuqmnxagtdrhbz",
            "wlpiogsvyfvcjuumlxaktdrhbz",
            "wwpiogsryfjcjuqmnxaktdrhbz",
            "wlpiogsvyfecjuqynxaktdrogz",
            "wlpiogsvyfecjpqmnxskbdrhbz",
            "wlpiogsvyfecjuhmfxaktvrhbz",
            "wlpiogevyfecjrqmnwaktdrhbz",
            "wlpiigsvyfemjuqmnxaktdrhtz",
            "wlpcogsvyfecjuqhnxakgdrhbz",
            "wupiogsvyfxcjuqmnxaktdrhgz",
            "wlsiogsvyfecjuqenxuktdrhbz",
            "wlpioglvyfecjujmexaktdrhbz",
            "wlriogsvyfeljuqmnxattdrhbz",
            "wlpiogsvyfecfuqmhxaktkrhbz",
            "wlppogsvyfecjuqmxxabtdrhbz",
            "wlniogsvyfevjuqwnxaktdrhbz",
            "wlhiogsvyfecjuqmnxactxrhbz",
            "ilpiogivyflcjuqmnxaktdrhbz",
            "wlpmogsvyfecjuqmnxaktdrlbs",
            "wipiogsvyfeqjuqmnxaktrrhbz",
            "wvpiogsvyfecjuqknxaktdrrbz",
            "wwpioguvyfecxuqmnxaktdrhbz",
            "wlpiogsvkfdcjuqmnxaktdzhbz",
            "wlpiogfvyfecjuqmnxadtdrhbg",
            "wlpiogsvyzefjuqfnxaktdrhbz",
            "wlpiogstyfechuqmnxaktdchbz",
            "wlpiogszyfedjuqmnxsktdrhbz",
            "wzpiozsvyfncjuqmnxaktdrhbz",
            "xlpiogsvyfefjuqmnmaktdrhbz",
            "wlpiogsvyfebxummnxaktdrhbz",
            "wlpiogsgyfecfurmnxaktdrhbz",
            "wlpqogsvyfecjuomnxaktdrhbi",
            "wlpiogjvufecjuqmnxaktdrhbd",
            "wlpiolsvyfecduqmnxaktrrhbz",
            "wlpxogsvyfecjuqmnxaktgrhbk",
            "wlpiogsfyfncjuqmnxsktdrhbz",
            "wlpioggvyfecjufmnxaktdrebz",
            "wlpiogsvyfecfujmnxaktdrwbz",
            "rlpiogsvyfecjlqmnxaktdqhbz",
            "wlpfogsvyfecjuimnxaktfrhbz"
    );

    public static void partOne() {
        System.out.println("Day Two, Part One:");

        int count2 = 0;
        int count3 = 0;

        for (String str : input) {
            Boolean[] exactlyTwoExactlyThree = exactlyTwoExactlyThree(str);

            if (exactlyTwoExactlyThree[0]) {
                count2++;
            }

            if (exactlyTwoExactlyThree[1]) {
                count3++;
            }
        }

        int result = count2 * count3;

        System.out.println(result);
    }

    private static Boolean[] exactlyTwoExactlyThree(String str) {
        Set<Character> singleChars = new HashSet<Character>();
        Set<Character> duplicateChars = new HashSet<Character>();
        Set<Character> tripleChars = new HashSet<Character>();

        for (char c : str.toCharArray()) {
            if (tripleChars.contains(c)) {
                tripleChars.remove(c);
            } else if (duplicateChars.contains(c)) {
                tripleChars.add(c);
                duplicateChars.remove(c);
            } else if (singleChars.contains(c)) {
                duplicateChars.add(c);
                singleChars.remove(c);
            } else {
                singleChars.add(c);
            }
        }

        return new Boolean[]{!duplicateChars.isEmpty(), !tripleChars.isEmpty()};
    }

    public static void partTwo() {
        System.out.println("Day Two, Part Two:");

        boolean foundMatch = false;

        for (int i = 0; i < input.size(); i++) {
            String str1 = input.get(i);
            char[] chars1 = str1.toCharArray();

            for (int j = i + 1; j < input.size(); j++) {
                String str2 = input.get(j);
                char[] chars2 = str2.toCharArray();

                if (getNumDiffs(chars1, chars2) == 1) {
                    printCommonLetters(str1, str2);
                    foundMatch = true;
                    break;
                }
            }

            if (foundMatch) {
                break;
            }
        }
    }

    private static void printCommonLetters(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        StringBuilder output = new StringBuilder();

        int i = 0;
        for  (char c1 : chars1) {
            if (chars2[i] == c1) {
                output.append(c1);
            }
            i++;
        }

        System.out.println(output);
    }

    private static int getNumDiffs(final char[] chars1, final char[] chars2) {

        int numDiffs = 0;

        for (int i = 0; i < chars1.length; i++) {
            char char1 = chars1[i];
            char char2 = chars2[i];

            if (char1 != char2) {
                numDiffs++;
            }
        }

        return numDiffs;
    }
}
