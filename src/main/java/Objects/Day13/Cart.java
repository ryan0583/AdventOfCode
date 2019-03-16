package Objects.Day13;

import java.util.Arrays;
import java.util.Objects;

public class Cart implements Comparable<Cart> {
    private static Direction UP = new Direction('<', '^', '>', 'v' );
    private static Direction DOWN = new Direction('>', 'v', '<', '^' );
    private static Direction LEFT = new Direction('v', '<', '^', '>' );
    private static Direction RIGHT = new Direction('^', '>', 'v', '<' );
    private static char[] intersectionMoves = new char[]{'L', 'S', 'R'};

    private Direction direction;
    private Integer[] currentPosition;
    private int intersectionMove = 0;
    private boolean markedForRemoval = false;

    public Cart(char cartChar, Integer[] currentPosition) {
        this.direction = cartChar == '^' ? UP
                : (cartChar == 'v' ? DOWN
                : (cartChar == '<' ? LEFT
                : (cartChar == '>' ? RIGHT : null)));
        this.currentPosition = currentPosition;
    }

    public void turn(char trackChar) {
        if (trackChar == '+' ) {
            turnIntersection();
        } else if ((trackChar == '/' && (direction.equals(LEFT) || direction.equals(RIGHT))
                || (trackChar == '\\' && (direction.equals(DOWN) || direction.equals(UP))))) {
            turnLeft();
        } else if ((trackChar == '/' && (direction.equals(UP) || direction.equals(DOWN)))
                || (trackChar == '\\' && (direction.equals(LEFT) || direction.equals(RIGHT)))) {
            turnRight();
        }
    }

    private void turnIntersection() {
        char intersectionMoveChar = intersectionMoves[intersectionMove];
        if (intersectionMoveChar == 'L' ) {
            turnLeft();
        } else if (intersectionMoveChar == 'R' ) {
            turnRight();
        }
        intersectionMove++;
        if (intersectionMove > 2) {
            intersectionMove = 0;
        }
    }

    private void turnLeft() {
        direction = new Direction(direction.getOpposite(), direction.getLeft(), direction.getCurrent(), direction.getRight());
    }

    private void turnRight() {
        direction = new Direction(direction.getCurrent(), direction.getRight(), direction.getOpposite(), direction.getLeft());
    }

    public void move() {
        if (direction.equals(UP)) {
            currentPosition = new Integer[]{currentPosition[0], currentPosition[1] - 1};
        } else if (direction.equals(DOWN)) {
            currentPosition = new Integer[]{currentPosition[0], currentPosition[1] + 1};
        } else if (direction.equals(LEFT)) {
            currentPosition = new Integer[]{currentPosition[0] - 1, currentPosition[1]};
        } else if (direction.equals(RIGHT)) {
            currentPosition = new Integer[]{currentPosition[0] + 1, currentPosition[1]};
        }
    }

    public Direction getCartChar() {
        return direction;
    }

    public void setCartChar(Direction direction) {
        this.direction = direction;
    }

    public String getCurrentPostionStr() {
        return currentPosition[0] + "," + currentPosition[1];
    }

    public Integer[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMarkedForRemoval() {
        return markedForRemoval;
    }

    public void setMarkedForRemoval(boolean markedForRemoval) {
        this.markedForRemoval = markedForRemoval;
    }

    @Override
    public int compareTo(Cart o) {
        int lastCmp = currentPosition[1].compareTo(o.getCurrentPosition()[1]);
        return (lastCmp != 0 ? lastCmp : currentPosition[0].compareTo(o.getCurrentPosition()[0]));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return intersectionMove == cart.intersectionMove &&
                markedForRemoval == cart.markedForRemoval &&
                Objects.equals(direction, cart.direction) &&
                Arrays.equals(currentPosition, cart.currentPosition);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(direction, intersectionMove, markedForRemoval);
        result = 31 * result + Arrays.hashCode(currentPosition);
        return result;
    }
}
