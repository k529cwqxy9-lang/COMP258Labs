/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.collections;

/**
 *
 * @author CrgCA
 */
public class GenericList<T extends Comparable<T>> {

    private GenericListNode<T> items;
    private GenericListNode<T> current;

    public GenericList() {
        items = null;
        current = null;
    }

    public void start() {
        current = items;
    }

    public void addAfter(T item) {
        GenericListNode<T> newNode
                = new GenericListNode<>(item);

        if (items == null) {
            items = newNode;
            current = newNode;
            return;
        }

        // Restart if current is missing
        if (current == null) {
            current = items;
        }

        newNode.setNextNode(
                current.getNextNode()
        );

        current.setNextNode(newNode);
        current = newNode;
    }

    public void addBefore(T item) {
        GenericListNode<T> newNode
                = new GenericListNode<>(item);

        if (items == null) {
            items = newNode;
            current = newNode;
            return;
        }

        // Restart if current is missing
        if (current == null) {
            current = items;
        }

        if (current == items) {
            newNode.setNextNode(items);
            items = newNode;
            current = newNode;
            return;
        }

        GenericListNode<T> previous
                = findPrevious();

        if (previous != null) {
            previous.setNextNode(newNode);
            newNode.setNextNode(current);
            current = newNode;
        }
    }

    public T getCurrent() {
        if (current == null) {
            return null;
        }

        return current.getData();
    }

    public T getItemAt(int position) {
        if (position < 0) {
            return null;
        }

        GenericListNode<T> temp = items;
        int index = 0;

        while (temp != null) {
            if (index == position) {
                return temp.getData();
            }

            temp = temp.getNextNode();
            index++;
        }

        return null;
    }

    public boolean advance() {
        if (current == null) {
            return false;
        }

        if (current.getNextNode() == null) {
            return false;
        }

        current = current.getNextNode();
        return true;
    }

    public void deleteCurrent() {
        if (current == null) {
            return;
        }

        if (current == items) {
            items = items.getNextNode();
            current = items;
            return;
        }

        GenericListNode<T> previous
                = findPrevious();

        if (previous != null) {
            previous.setNextNode(
                    current.getNextNode()
            );

            current = current.getNextNode();
        }
    }

    public T getMaximum() {
        if (items == null) {
            return null;
        }

        GenericListNode<T> maximum = items;
        GenericListNode<T> temp
                = items.getNextNode();

        while (temp != null) {
            if (temp.getData().compareTo(
                    maximum.getData()) > 0) {
                maximum = temp;
            }

            temp = temp.getNextNode();
        }

        // Move current to the maximum item
        current = maximum;

        return maximum.getData();
    }

    public void print() {
        if (items == null) {
            System.out.println(
                    "the list is empty"
            );
            return;
        }

        GenericListNode<T> temp = items;
        int position = 0;

        while (temp != null) {
            System.out.println(
                    position + ": "
                    + temp.getData()
            );

            temp = temp.getNextNode();
            position++;
        }
    }

    public boolean isEmpty() {
        return items == null;
    }

    private GenericListNode<T> findPrevious() {
        GenericListNode<T> temp = items;

        while (temp != null) {
            if (temp.getNextNode() == current) {
                return temp;
            }

            temp = temp.getNextNode();
        }

        return null;
    }
}
