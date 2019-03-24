package Objects.Day15;

public class Combatant implements Comparable<Combatant> {

    private Character type;
    private Space currentPosition;
    private int hp = 200;

    private int attackPoints = 3;

    public Combatant(Character type, Integer[] currentPosition) {
        this.type = type;
        this.currentPosition = new Space(null, currentPosition[0], currentPosition[1]);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void sufferAttack(int hpReduction) {
        hp -= hpReduction;
    }

    public Character getType() {
        return type;
    }

    public Space getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Space currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public int compareTo(Combatant o) {
        return currentPosition.compareTo(o.getCurrentPosition());
    }
}
