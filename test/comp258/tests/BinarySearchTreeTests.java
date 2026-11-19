package comp258.tests;

import comp258.collections.BSTNode;
import comp258.collections.BinarySearchTree;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinarySearchTreeTests {

    private static int checks = 0;

    private static void check(boolean result, String message) {
        checks++;
        if (!result) {
            throw new AssertionError(message);
        }
    }

    private static String output(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(bytes));
            action.run();
        } finally {
            System.setOut(original);
        }
        return bytes.toString().replace("\r\n", "\n");
    }

    private static void rejectsNull(Runnable action) {
        boolean rejected = false;
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            rejected = true;
        }
        check(rejected, "null should be rejected");
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        check(tree.getSize() == 0, "empty size");
        check(!tree.searchTree(7), "empty search");
        check(output(tree::printTree).equals("the tree is empty\n"), "empty print");
        rejectsNull(() -> tree.addNode(null));
        check(tree.getSize() == 0, "failed insert leaves size unchanged");

        int[] numbers = {7, 4, 2, 9, 1, 12, 10, 8, 5, 3, 13};
        for (int number : numbers) {
            tree.addNode(number);
        }
        check(tree.getSize() == 11, "example size");
        for (int number : numbers) {
            check(tree.searchTree(number), "find " + number);
        }
        for (int missing : new int[]{0, 6, 11, 14}) {
            check(!tree.searchTree(missing), "missing " + missing);
        }
        String expected = "1\n2\n3\n4\n5\n7\n8\n9\n10\n12\n13\n";
        check(output(tree::printTree).equals(expected), "example in order");
        check(tree.getSize() == 11, "search and print do not change size");
        rejectsNull(() -> tree.addNode(null));
        rejectsNull(() -> tree.searchTree(null));
        check(tree.getSize() == 11, "invalid inputs do not change size");

        BSTNode<Integer> root = new BSTNode<>(7);
        for (int i = 1; i < numbers.length; i++) {
            root.add(numbers[i]);
        }
        check(root.getLeft().getData() == 4, "example left child");
        check(root.getRight().getData() == 9, "example right child");
        check(root.getLeft().getLeft().getRight().getData() == 3, "example left subtree");
        check(root.getRight().getRight().getLeft().getData() == 10, "example right subtree");
        check(output(root::printTree).equals(expected), "node traversal");
        rejectsNull(() -> new BSTNode<Integer>(null));
        rejectsNull(() -> root.add(null));
        rejectsNull(() -> root.setData(null));
        check(root.getData() == 7, "failed setter leaves data unchanged");

        BinarySearchTree<String> words = new BinarySearchTree<>();
        words.addNode("mango");
        words.addNode("apple");
        words.addNode("zebra");
        words.addNode("pear");
        check(words.searchTree("apple"), "string search left");
        check(words.searchTree("zebra"), "string search right");
        check(!words.searchTree("banana"), "missing string");
        check(output(words::printTree).equals("apple\nmango\npear\nzebra\n"), "string order");

        BinarySearchTree<Integer> duplicates = new BinarySearchTree<>();
        duplicates.addNode(7);
        duplicates.addNode(7);
        duplicates.addNode(7);
        check(duplicates.getSize() == 3, "duplicate count");
        check(duplicates.searchTree(7), "duplicate search");
        check(output(duplicates::printTree).equals("7\n7\n7\n"), "duplicate traversal");

        BinarySearchTree<Integer> ascending = new BinarySearchTree<>();
        BinarySearchTree<Integer> descending = new BinarySearchTree<>();
        for (int i = 1; i <= 5; i++) {
            ascending.addNode(i);
            descending.addNode(6 - i);
        }
        check(output(ascending::printTree).equals("1\n2\n3\n4\n5\n"), "right chain");
        check(output(descending::printTree).equals("1\n2\n3\n4\n5\n"), "left chain");
        check(ascending.searchTree(5) && descending.searchTree(1), "chain ends");
        check(!ascending.searchTree(6) && !descending.searchTree(0), "missing chain values");

        BinarySearchTree<Integer> limits = new BinarySearchTree<>();
        limits.addNode(0);
        limits.addNode(Integer.MIN_VALUE);
        limits.addNode(Integer.MAX_VALUE);
        check(limits.searchTree(Integer.MIN_VALUE), "minimum integer");
        check(limits.searchTree(Integer.MAX_VALUE), "maximum integer");
        check(output(limits::printTree).equals("-2147483648\n0\n2147483647\n"), "integer limits");

        System.out.println(checks + " binary search tree checks passed.");
    }
}
