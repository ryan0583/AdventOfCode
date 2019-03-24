package Objects.Day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Space implements Comparable<Space> {

    private Space previousSpace;
    private Integer xCoord;
    private Integer yCoord;

    public Space(Space previousSpace, int xCoord, int yCoord) {
        this.previousSpace = previousSpace;
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

    public Integer getxCoord() {
        return xCoord;
    }

    public void setxCoord(Integer xCoord) {
        this.xCoord = xCoord;
    }

    public Integer getyCoord() {
        return yCoord;
    }

    public void setyCoord(Integer yCoord) {
        this.yCoord = yCoord;
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
        int lastCmp = doSpaceComparison(this, o);

        if (lastCmp != 0) {
            return lastCmp;
        }

        List<Space> thisRoute = this.getRoute(new ArrayList<>());
        List<Space> otherRoute = o.getRoute(new ArrayList<>());

        if (thisRoute.size() >= 2 && otherRoute.size() >= 2) {
            return doSpaceComparison(thisRoute.get(1), otherRoute.get(1));
        }

        return 0;
    }

    private int doSpaceComparison(Space space1, Space space2) {
        int lastCmp = space1.getyCoord().compareTo(space2.getyCoord());
        return (lastCmp != 0 ? lastCmp : space1.getxCoord().compareTo(space2.getxCoord()));
    }
}
