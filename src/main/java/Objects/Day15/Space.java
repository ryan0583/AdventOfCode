package Objects.Day15;

import java.util.List;
import java.util.Objects;

public class Space implements Comparable<Space> {

    private Space previousSpace;
    private Integer xCoord;
    private Integer yCoord;
    private List<Space> adjacentSpaces;
    private boolean routable = false;

    public Space(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getRouteSteps() {
        int routeSteps = 0;
        Space parent = getPreviousSpace();
        if (parent != null) {
            routeSteps++;
            while (parent != null) {
                routeSteps++;
                parent = parent.getPreviousSpace();
            }
        }

        return routeSteps;
    }

    public List<Space> getRoute(List<Space> route) {
        if (previousSpace != null) {
            previousSpace.getRoute(route);
        }
        route.add(this);

        return route;
    }

    public void printRoute() {
        if (previousSpace != null) {
            previousSpace.printRoute();
        }
        System.out.println(this);
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public Integer getyCoord() {
        return yCoord;
    }

    public void setyCoord(Integer yCoord) {
        this.yCoord = yCoord;
    }

    public List<Space> getAdjacentSpaces() {
        return adjacentSpaces;
    }

    public void setAdjacentSpaces(List<Space> adjacentSpaces) {
        this.adjacentSpaces = adjacentSpaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return xCoord == space.xCoord &&
                yCoord == space.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }

    public boolean isRoutable() {
        return routable;
    }

    public void setRoutable(boolean routable) {
        this.routable = routable;
    }

    @Override
    public String toString() {
        return "Space{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
    }

    public Space getPreviousSpace() {
        return previousSpace;
    }

    public void setPreviousSpace(Space previousSpace) {
        this.previousSpace = previousSpace;
    }

    @Override
    public int compareTo(Space o) {
        int lastCmp = yCoord.compareTo(o.getyCoord());
        return (lastCmp != 0 ? lastCmp : xCoord.compareTo(o.getxCoord()));
    }
}
