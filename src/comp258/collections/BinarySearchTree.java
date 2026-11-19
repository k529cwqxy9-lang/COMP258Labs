package comp258.collections;

public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addNode(T nodeData) {
        if (root == null) {
            root = new BSTNode<>(nodeData);
        } else {
            root.add(nodeData);
        }
        size++;
    }

    public boolean searchTree(T dataToFind) {
        if (dataToFind == null) {
            throw new IllegalArgumentException("tree values cannot be null");
        }
        return root != null && root.searchTree(dataToFind);
    }

    public void printTree() {
        if (root == null) {
            System.out.println("the tree is empty");
            return;
        }
        root.printTree();
    }
}
