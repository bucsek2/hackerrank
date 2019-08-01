package hu.bucsek2.advanced.java_visitor_pattern;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        //nothing to do here
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private static final int M = 1000000007;


    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        product(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        product(leaf);
    }

    private void product(Tree node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int greenLeaf = 0;
    private int evenDepth = 0;

    public int getResult() {
        return Math.abs(greenLeaf - evenDepth);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeaf += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] c = new int[n];
            boolean[] marked = new boolean[n];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            Tree[] nodes = new Tree[n];
            for (int i = 0; i < n; i++) {
                map.put(i + 1, new HashSet<Integer>());
                x[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }

            Queue<String> queue = new ArrayDeque<>();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] edge = s.split(" ");
                int v = Integer.parseInt(edge[0]);
                int u = Integer.parseInt(edge[1]);

                Set<Integer> direction1 = map.get(v);
                direction1.add(u);
                map.put(v, direction1);

                Set<Integer> direction2 = map.get(u);
                direction2.add(v);
                map.put(u, direction2);
            }

            Tree root;
            Set<Integer> children = map.get(1);
            if (children.isEmpty()) {
                root = new TreeLeaf(x[0], Color.values()[c[0]], 0);
            } else {
                marked[0] = true;
                root = new TreeNode(x[0], Color.values()[c[0]], 0);
                for (int child : children) {
                    queue.add(1 + " " + child);
                }
            }
            nodes[0] = root;

            while (!queue.isEmpty()) {
                String[] element = queue.poll().split(" ");

                int parent = Integer.parseInt(element[0]);
                int nodeIndex = Integer.parseInt(element[1]);

                if (marked[nodeIndex - 1]) {
                    continue;
                }

                marked[nodeIndex - 1] = true;
                children = map.get(nodeIndex);

                Tree node;

                boolean markedChildren = true;
                for (int child : children) {
                    boolean markedChild = marked[child - 1];
                    markedChildren &= markedChild;
                    if (!markedChild) {
                        queue.add(nodeIndex + " " + child);
                    }
                }
                if (markedChildren) {
                    node = new TreeLeaf(x[nodeIndex - 1], Color.values()[c[nodeIndex - 1]], nodes[parent - 1].getDepth() + 1);
                } else {
                    node = new TreeNode(x[nodeIndex - 1], Color.values()[c[nodeIndex - 1]], nodes[parent - 1].getDepth() + 1);
                }

                ((TreeNode) nodes[parent - 1]).addChild(node);
                nodes[nodeIndex - 1] = node;
            }

            return root;
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}