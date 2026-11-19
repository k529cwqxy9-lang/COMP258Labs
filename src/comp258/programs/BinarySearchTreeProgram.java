package comp258.programs;

import comp258.collections.BinarySearchTree;
import comp258.framework.ConsoleProgram;

public class BinarySearchTreeProgram extends ConsoleProgram {

    private BinarySearchTree<Integer> tree;

    public BinarySearchTreeProgram() {
        tree = new BinarySearchTree<>();
    }

    public static void main(String[] args) {
        new BinarySearchTreeProgram().run();
    }

    @Override
    public void startProgram() {
        System.out.println("binary search tree program started");
    }

    @Override
    public int showMenu() {
        System.out.println("\n========== tree menu ==========");
        System.out.println("1. add a number");
        System.out.println("2. search for a number");
        System.out.println("3. print the tree in order");
        System.out.println("4. display number of items");
        System.out.println("5. load the example tree");
        System.out.println("0. exit program");
        return readInt("choose an option: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                int number = readInt("enter a number: ");
                tree.addNode(number);
                System.out.println("number added");
                break;
            case 2:
                number = readInt("enter a number to find: ");
                if (tree.searchTree(number)) {
                    System.out.println(number + " was found");
                } else {
                    System.out.println(number + " was not found");
                }
                break;
            case 3:
                tree.printTree();
                break;
            case 4:
                System.out.println("number of items: " + tree.getSize());
                break;
            case 5:
                loadExampleTree();
                break;
            default:
                System.out.println("please choose a number from 0 to 5");
        }
    }

    private void loadExampleTree() {
        int[] numbers = {7, 4, 2, 9, 1, 12, 10, 8, 5, 3, 13};
        // replace the current tree with the example
        tree = new BinarySearchTree<>();
        for (int number : numbers) {
            tree.addNode(number);
        }
        System.out.println("example tree loaded");
        tree.printTree();
    }

    @Override
    public void endProgram() {
        System.out.println("binary search tree program ended");
    }
}
