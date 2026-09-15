/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;
import java.util.Arrays;
/**
 *
 * @author CrgCA
 */
public class ArrayManager {
    private int[] items;
    private int count;

    public ArrayManager() {
        items = new int[10];
        count = 0;
    }

    public ArrayManager(int capacity) {
        // prevent negative capacity
        if (capacity < 0) {
            capacity = 0;
        }

        items = new int[capacity];
        count = 0;
    }

    public ArrayManager(int[] values) {
        if (values == null) {
            items = new int[10];
            count = 0;
        } else {
            items = Arrays.copyOf(values, values.length);
            count = values.length;
        }
    }

    public int size() {
        return count;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("the array manager is empty");
            return;
        }

        System.out.print("items: ");

        for (int i = 0; i < count; i++) {
            System.out.print(items[i]);

            if (i < count - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public void add(int n) {
        makeRoom();
        items[count] = n;
        count++;
    }

    public void remove(int pos)
            throws NoItemsException, OutOfBoundsException {

        if (isEmpty()) {
            throw new NoItemsException(
                "cannot remove from an empty array manager"
            );
        }

        if (pos < 0 || pos >= count) {
            throw new OutOfBoundsException(
                "remove position must be from 0 to " + (count - 1)
            );
        }

        // shift items to the left
        for (int i = pos; i < count - 1; i++) {
            items[i] = items[i + 1];
        }

        count--;
        items[count] = 0;
    }

    public void addAt(int n, int pos)
            throws OutOfBoundsException {

        if (pos < 0 || pos > count) {
            throw new OutOfBoundsException(
                "add position must be from 0 to " + count
            );
        }

        makeRoom();

        // shift items to the right
        for (int i = count; i > pos; i--) {
            items[i] = items[i - 1];
        }

        items[pos] = n;
        count++;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void makeRoom() {
        if (count == items.length) {
            int newCapacity;

            if (items.length == 0) {
                newCapacity = 1;
            } else {
                newCapacity = items.length * 2;
            }

            items = Arrays.copyOf(items, newCapacity);
        }
    }
}
