package Utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private static final String TEST_FILENAME = "src/main/resources/Day17TestInput.txt";

    private final FileReader fileReader = new FileReader(TEST_FILENAME);

    @Test
    public void canReadInput() {
        final List<String> expectedLines = List.of(
                "x=495, y=2..7",
                "y=7, x=495..501",
                "x=501, y=3..7",
                "x=498, y=2..4",
                "x=506, y=1..2",
                "x=498, y=10..13",
                "x=504, y=10..13",
                "y=13, x=498..504");

        final List<String> actual = fileReader.readFile();
        assertEquals(expectedLines, actual);
    }

}