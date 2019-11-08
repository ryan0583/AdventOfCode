package Objects.Day17;

import Utils.FileReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MapTest {

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private Map map;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void createMapReturnsEmptyMapOfCorrectSize() {
        final char[][] expected = new char[20][20];
        Arrays.stream(expected)
                .forEach(row -> Arrays.fill(row, '.'));

        final char[][] actual = map.createEmptyMap(20, 20);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getClayPositionsReturnsCorrectPosition() {
        when(fileReader.readFile()).thenReturn(
                List.of("x=1, y=2", "y=3, x=4", "x=5..7, y=8", "x=9, y=10..12", "y=13..15, x=16", "y=17, x=18..20")
        );
        final List<Clay> clayPositions = map.getClayPositions();
        assertEquals(buildClayList(), clayPositions);
    }

    @Test
    public void addClayReturnsOriginalArray() {
        final char[][] input = new char[20][20];
        Arrays.stream(input)
                .forEach(row -> Arrays.fill(row, '.'));
        final char[][] actual = map.addClay(input, List.of());
        assertArrayEquals(input, actual);
    }

    @Test
    public void addClayReturnsArrayWithClay() {
        final char[][] input = new char[22][22];
        Arrays.stream(input)
                .forEach(row -> Arrays.fill(row, '.'));
        final char[][] actual = map.addClay(input, buildClayList());
        final char[][] expected = new char[22][22];
        Arrays.stream(expected)
                .forEach(row -> Arrays.fill(row, '.'));
        expected[2][1] = '#';
        expected[3][4] = '#';
        expected[8][5] = '#';
        expected[8][6] = '#';
        expected[8][7] = '#';
        expected[10][9] = '#';
        expected[11][9] = '#';
        expected[12][9] = '#';
        expected[13][16] = '#';
        expected[14][16] = '#';
        expected[15][16] = '#';
        expected[17][18] = '#';
        expected[17][19] = '#';
        expected[17][20] = '#';
        assertArrayEquals(expected, actual);
    }

    private List<Clay> buildClayList() {
        return List.of(
                new Clay(1, 2),
                new Clay(4, 3),
                new Clay(5, 8),
                new Clay(6, 8),
                new Clay(7, 8),
                new Clay(9, 10),
                new Clay(9, 11),
                new Clay(9, 12),
                new Clay(16, 13),
                new Clay(16, 14),
                new Clay(16, 15),
                new Clay(18, 17),
                new Clay(19, 17),
                new Clay(20, 17));
    }
}