package Objects.Day8;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int numChildren;
    private int numMetaData;
    private List<Node> children = new ArrayList<>();
    private List<Integer> metaDataEntries = new ArrayList<>();

    public Node(int numChildren, int numMetaData) {
        this.numChildren = numChildren;
        this.numMetaData = numMetaData;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public int getNumMetaData() {
        return numMetaData;
    }

    public void setNumMetaData(int numMetaData) {
        this.numMetaData = numMetaData;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Integer> getMetaDataEntries() {
        return metaDataEntries;
    }

    public void setMetaDataEntries(List<Integer> metaDataEntries) {
        this.metaDataEntries = metaDataEntries;
    }
}
