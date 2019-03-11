import Objects.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day8 {
    //    private static List<Integer> input = Arrays.asList(2,3,0,3,10,11,12,1,1,0,1,99,2,1,1,2);
    private static List<Integer> input;


    public static void partOne() {
        System.out.println("Day Eight, Part One:");
        initialiseInput();
        List<Node> nodes = generateNodes();
        System.out.println(sumMetaData(nodes));
    }

    public static void partTwo() {
        System.out.println("Day Eight, Part One:");
        initialiseInput();
        List<Node> nodes = generateNodes();
        System.out.println(calculateNodeValue(nodes.get(0), 0));
    }

    private static void initialiseInput() {
        input = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ryan.Griffiths\\Documents\\AOC\\src\\main\\resources\\Day8Input.txt"));
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                for (String valStr : values) {
                    input.add(Integer.parseInt(valStr));
                }
            }

            br.close();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    private static List<Node> generateNodes() {
        List<Node> nodes = new ArrayList<>();
        generateAndAddNode(nodes, 0, null);
        return nodes;
    }

    private static int calculateNodeValue(Node node, int runningTotal) {
        if (node.getNumChildren() > 0) {
            for (int metaData : node.getMetaDataEntries()) {
                if (metaData <= node.getNumChildren()) {
                    Node child = node.getChildren().get(metaData - 1);
                    runningTotal = calculateNodeValue(child, runningTotal);
                }
            }
        } else {
            for (int metaData : node.getMetaDataEntries()) {
                runningTotal += metaData;
            }
        }

        return runningTotal;
    }

    private static int generateAndAddNode(List<Node> nodes, int index, Node parent) {
        int numChildren = input.get(index);
        index++;
        int numMetaData = input.get(index);
        index++;

        Node node = new Node(numChildren, numMetaData);
        nodes.add(node);
        if (parent != null) {
            parent.getChildren().add(node);
        }

        for (int i = 0; i < numChildren; i++) {
            index = generateAndAddNode(nodes, index, node);
        }

        for (int i = 0; i < numMetaData; i++) {
            int metaData = input.get(index);
            node.getMetaDataEntries().add(metaData);
            index++;
        }

        return index;
    }

    private static int sumMetaData(List<Node> nodes) {
        int total = 0;
        for (Node node : nodes) {
            for (int metaData : node.getMetaDataEntries()) {
                total += metaData;
            }
        }

        return total;
    }
}
