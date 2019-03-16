package Objects.Day14;

public class Elf {
    int currentScore;
    int currentPosition;

    public Elf(int currentScore, int currentPosition) {
        this.currentScore = currentScore;
        this.currentPosition = currentPosition;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
