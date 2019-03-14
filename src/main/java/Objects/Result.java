package Objects;

public class Result {
    int totalPower;
    int y;
    int x;
    int squareSize;

    public Result(int totalPower, int y, int x, int squareSize) {
        this.totalPower = totalPower;
        this.y = y;
        this.x = x;
        this.squareSize = squareSize;
    }

    public void print() {
        System.out.println(x + "," + y + "," + squareSize);
    }

    public int getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }
}
