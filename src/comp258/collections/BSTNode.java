package comp258.collections;

public class BSTNode<T extends Comparable<T>> {

    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T data) {
        setData(data);
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("tree values cannot be null");
        }
        this.data = data;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    public void add(T newData) {
        if (newData == null) {
            throw new IllegalArgumentException("tree values cannot be null");
        }

        if (newData.compareTo(data) < 0) {
            if (left == null) {
                left = new BSTNode<>(newData);
            } else {
                left.add(newData);
            }
        } else {
            // equal values also go right
            if (right == null) {
                right = new BSTNode<>(newData);
            } else {
                right.add(newData);
            }
        }
    }

    public boolean searchTree(T dataToFind) {
        if (dataToFind == null) {
            throw new IllegalArgumentException("tree values cannot be null");
        }

        int result = dataToFind.compareTo(data);

        if (result == 0) {
            return true;
        }
        if (result < 0) {
            return left != null && left.searchTree(dataToFind);
        }
        return right != null && right.searchTree(dataToFind);
    }

    public void printTree() {
        // visit the smaller values first
        if (left != null) {
            left.printTree();
        }
        System.out.println(data);
        if (right != null) {
            right.printTree();
        }
    }
}
