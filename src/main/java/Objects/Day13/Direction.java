package Objects.Day13;

import java.util.Objects;

public class Direction {
    private char current;
    private char left;
    private char right;
    private char opposite;

    public Direction(char left, char current, char right, char opposite) {
        this.current = current;
        this.left = left;
        this.right = right;
        this.opposite = opposite;
    }


    public char getCurrent() {
        return current;
    }

    public void setCurrent(char current) {
        this.current = current;
    }

    public char getLeft() {
        return left;
    }

    public void setLeft(char left) {
        this.left = left;
    }

    public char getRight() {
        return right;
    }

    public void setRight(char right) {
        this.right = right;
    }

    public char getOpposite() {
        return opposite;
    }

    public void setOpposite(char opposite) {
        this.opposite = opposite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return current == direction.current &&
                left == direction.left &&
                right == direction.right &&
                opposite == direction.opposite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, left, right, opposite);
    }
}
