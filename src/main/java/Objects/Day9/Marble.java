package Objects.Day9;

public class Marble {
    private int value;
    private Marble previousMarble;
    private Marble nextMarble;

    public Marble(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Marble getPreviousMarble() {
        return previousMarble;
    }

    public void setPreviousMarble(Marble previousMarble) {
        this.previousMarble = previousMarble;
    }

    public Marble getNextMarble() {
        return nextMarble;
    }

    public void setNextMarble(Marble nextMarble) {
        this.nextMarble = nextMarble;
    }
}
