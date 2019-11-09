package Objects.Day17;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class GridFrame extends JFrame {
    private char[][] arr;

    public GridFrame(char[][] arr) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.arr = arr;
        setSize(arr[0].length * 2 + 50, 500);

        final JScrollPane scrollPane = new JScrollPane(new GPanel());
        add(scrollPane);
    }

    class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(arr[0].length * 2, arr.length * 2));
        }

        @Override
        public void paintComponent(Graphics g) {
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr[0].length; x++) {
                    char c = arr[y][x];
                    switch (c) {
                        case Map.SAND:
                            g.setColor(Color.ORANGE);
                            break;
                        case Map.CLAY:
                            g.setColor(Color.RED);
                            break;
                        case Map.SPRING:
                            g.setColor(Color.GREEN);
                            break;
                        default:
                            g.setColor(Color.BLUE);
                    }


                    g.fillRect(x * 2, y * 2, 2, 2);
                }
            }
        }
    }
}
