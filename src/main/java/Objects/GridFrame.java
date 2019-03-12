package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class GridFrame extends JFrame {
    private Integer[][] arr;

    public GridFrame(Integer[][] arr) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.arr = arr;
        setSize(arr[0].length * 2, arr.length * 2);

        add(new GPanel());
    }

    class GPanel extends JPanel {
        public GPanel() {
            setSize(new Dimension(arr[0].length * 2, arr.length * 2));
        }

        @Override
        public void paintComponent(Graphics g) {
            HashMap<Integer, Color> colors = new HashMap<>();
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr[0].length; x++) {
                    int value = arr[y][x];
                    Color color;
                    if (!colors.containsKey(value)) {
                        if (value == 0) {
                            color = Color.BLACK;
                        } else {
                            color = generateColor();
                            while (containsSimilarColor(colors.values(), color)) {
                                color = generateColor();
                            }
                        }
                        colors.put(value, color);
                    } else {
                        color = colors.get(value);
                    }

                    g.setColor(color);
                    g.fillRect(x * 2, y * 2, 2, 2);
                }
            }
        }

        private boolean containsSimilarColor(Collection<Color> colors, Color color) {
            boolean similarColorFound = false;
            for (Color colorCheck : colors) {
                if (Math.abs(colorCheck.getRed() - color.getRed()) < 10
                        && Math.abs(colorCheck.getGreen() - color.getGreen()) < 10
                        && Math.abs(colorCheck.getBlue() - color.getBlue()) < 10) {
                    similarColorFound = true;
                    break;
                }
            }

            return similarColorFound;
        }

        private Color generateColor() {
            Random random = new Random();
            final float hue = random.nextFloat();
            final float saturation = 0.9f;//1.0 for brilliant, 0.0 for dull
            final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
            return Color.getHSBColor(hue, saturation, luminance);
        }
    }
}
