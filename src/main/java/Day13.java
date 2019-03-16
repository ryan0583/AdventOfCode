import Objects.Day13.Cart;
import Objects.Day13.Track;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day13 {

    public static void partOne() {
        Track track = generateTrack();

        List<Cart> carts = findCarts(track);
        String collisionCoords = null;

        while (collisionCoords == null) {
            collisionCoords = nextTick(track, carts);
        }

        System.out.println();
        System.out.println(collisionCoords);
    }

    public static void partTwo() {
        Track track = generateTrack();

        List<Cart> carts = findCarts(track);

        while (carts.size() > 1) {
            nextTick(track, carts);
        }

        System.out.println(carts.get(0).getCurrentPostionStr());
    }

    private static String nextTick(Track track, List<Cart> carts) {
        printTrack(track, carts);

        System.out.println("TICK!");

        String firstCollision = null;

        List<Cart> cartsToRemove = new ArrayList<>();

        Collections.sort(carts);

        for (Cart cart : carts) {
            if (cart.isMarkedForRemoval()) {
                continue;
            }
            cart.move();
            String newPosition = cart.getCurrentPostionStr();
            Cart collidedCart = findCollidedCart(cart, carts);
            if (collidedCart != null) {
                if (firstCollision == null) {
                    firstCollision = newPosition;
                }
                cart.setMarkedForRemoval(true);
                collidedCart.setMarkedForRemoval(true);
                cartsToRemove.add(cart);
                cartsToRemove.add(collidedCart);
            } else {
                char trackChar = track.getTrack()[cart.getCurrentPosition()[1]][cart.getCurrentPosition()[0]];
                cart.turn(trackChar);
            }
        }

        carts.removeAll(cartsToRemove);

        return firstCollision;
    }

    private static Cart findCollidedCart(Cart cartToCheck, List<Cart> carts) {
        Integer[] positionToCheck = cartToCheck.getCurrentPosition();
        for (Cart cart : carts) {
            if (!cart.isMarkedForRemoval()
                    && !cart.equals(cartToCheck)
                    && Arrays.equals(positionToCheck, cart.getCurrentPosition())) {
                return cart;
            }
        }
        return null;
    }

    private static void printTrack(Track track, List<Cart> carts) {
        char[][] trackToPrint = new char[track.getTrack().length][track.getTrack()[0].length];

        for (int y = 0; y < track.getTrack().length; y++) {
            trackToPrint[y] = Arrays.copyOf(track.getTrack()[y], track.getTrack()[y].length);
        }

        for (Cart cart : carts) {
            Integer[] position = cart.getCurrentPosition();
            trackToPrint[position[1]][position[0]] = cart.getDirection().getCurrent();
        }

        System.out.println(Arrays.deepToString(trackToPrint).replace("], ", "]\n").replace("[", "").replace("]", "").replace(", ", " "));
    }

    private static Track generateTrack() {
        List<String> fileLines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Day13Input.txt"));
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

        char[][] track = new char[fileLines.size()][xDim];

        for (char[] row : track) {
            Arrays.fill(row, ' ' );
        }

        for (int y = 0; y < fileLines.size(); y++) {
            char[] row = fileLines.get(y).toCharArray();
            for (int x = 0; x < row.length; x++) {
                track[y][x] = row[x];
            }
        }

        return new Track(track);
    }

    private static List<Cart> findCarts(Track track) {
        List<Cart> carts = new ArrayList<>();
        Set<Character> cartChars = Set.of('<', '^', '>', 'v' );

        for (int y = 0; y < track.getTrack().length; y++) {
            for (int x = 0; x < track.getTrack()[0].length; x++) {
                char c = track.getTrack()[y][x];
                if (cartChars.contains(c)) {
                    carts.add(new Cart(c, new Integer[]{x, y}));
                    track.getTrack()[y][x] = '*';
                }
            }
        }

        return carts;
    }
}
